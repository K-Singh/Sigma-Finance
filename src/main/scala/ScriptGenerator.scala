import org.ergoplatform.appkit.{Address, BlockchainContext, ConstantsBuilder, ErgoContract, ErgoId}
import scorex.crypto.hash.Blake2b256
import sigmastate.eval.CostingSigmaDslBuilder.Colls
import special.collection.Coll

import scala.io.Source

object ScriptGenerator {
  private final val BASE_PATH   = "contracts/"
  private final val EXT         = ".ergo"

  private final val BOND_PREFIX = "BondContract"
  private final val ORD_PREFIX  = "OpenOrder"

  private final val FIX_HEIGHT  = "FixedHeight"
  private final val ON_CLOSE    = "OnClose"

  private final val ERG         = "ERG"
  private final val TOKEN       = "Token"

  def mkScript(name: String): String = {
    val src = Source.fromFile(BASE_PATH + name + EXT)
    val script = src.mkString
    src.close()
    script
  }

  def idFromStr(idStr: String): Coll[Byte] = {
    Colls.fromArray(
      ErgoId.create(
        idStr
      ).getBytes
    )
  }

  def mkBondContract(ctx: BlockchainContext, optTokenId: Option[String]): ErgoContract = {
    optTokenId match {
      case Some(id) =>
        val script      = mkScript(BOND_PREFIX + TOKEN)
        val constants   = ConstantsBuilder
          .create()
          .item("_tokenId", idFromStr(id))
          .build()

        ctx.compileContract(constants, script)
      case None =>
        val script      = mkScript(BOND_PREFIX + ERG)
        val constants   = ConstantsBuilder.empty()

        ctx.compileContract(constants, script)
    }
  }

  def mkOrderContract(ctx: BlockchainContext, isFixed: Boolean, optTokenId: Option[String]): ErgoContract = {
    val bondContractHash = {
      val bondContract = mkBondContract(ctx, optTokenId)
      Blake2b256.hash(
        bondContract.getErgoTree.bytes
      )
    }

    val devPK = Address.create("9hgm8enrcPL3UUVHFpmLXxpSNCxWs5LxGBV6YS8Xy8KSoTtPPhE").getPublicKey

    val orderType = {
      if(isFixed)
        FIX_HEIGHT
      else
        ON_CLOSE
    }

    optTokenId match {
      case Some(id) =>
        val script      = mkScript(ORD_PREFIX + orderType + TOKEN)
        val constants   = ConstantsBuilder
          .create()
          .item("_tokenId", idFromStr(id))
          .item("_devPK", devPK)
          .item("_bondContractHash", Colls.fromArray(bondContractHash))
          .build()

        ctx.compileContract(constants, script)
      case None =>
        val script      = mkScript(ORD_PREFIX + orderType + ERG)
        val constants   = ConstantsBuilder
          .create()
          .item("_devPK", devPK)
          .item("_bondContractHash", Colls.fromArray(bondContractHash))
          .build()

        ctx.compileContract(constants, script)
    }
  }
}
