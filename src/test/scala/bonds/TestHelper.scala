package ksingh.sigmabonds
package bonds

import org.ergoplatform.ErgoAddress
import org.ergoplatform.appkit._

object TestHelper {
  val networkType: NetworkType = NetworkType.TESTNET
  val nodePort: String = if (networkType == NetworkType.MAINNET) ":9053/" else ":9052/"

  val client = RestApiErgoClient.create(
    "http://213.239.193.208" + nodePort,
    networkType,
    "",
    RestApiErgoClient.getDefaultExplorerUrl(networkType))

  case class Party(address: Address, prover: ErgoProver, ergoAddress: ErgoAddress)

  def token(id: ErgoId, amnt: Long) = new ErgoToken(id, amnt)
  val buyer: Party = {
    client.execute {
      ctx =>
        val prover = ctx.newProverBuilder().withDLogSecret(BigInt(0).bigInteger).build()
        Party(prover.getAddress, prover, prover.getAddress.getErgoAddress)
    }
  }

  val seller: Party = {
    client.execute {
      ctx =>
        val prover = ctx.newProverBuilder().withDLogSecret(BigInt(1).bigInteger).build()
        Party(prover.getAddress, prover, prover.getAddress.getErgoAddress)
    }
  }

  val dev: Party = {
    client.execute{
      ctx =>
        val prover = ctx.newProverBuilder().withDLogSecret(BigInt(2).bigInteger).build()
        Party(prover.getAddress, prover, prover.getAddress.getErgoAddress)
    }
  }

  def walletBox(ctx: BlockchainContext, owner: Party, amount: Long, tokens: Seq[ErgoToken] = Seq.empty[ErgoToken]): OutBox = {
    val box = ctx.newTxBuilder().outBoxBuilder()
      .value(amount)
      .contract(owner.address.toErgoContract)

    if(tokens.nonEmpty)
      box.tokens(tokens:_*)

    box.build()
  }

  def mintToken(ctx: BlockchainContext, owner: Party, amnt: Long, amntTok: Long, box: InputBox): SignedTransaction = {
    val out = ctx.newTxBuilder().outBoxBuilder()
      .value(amnt)
      .mintToken(new Eip4Token(box.getId.toString, amntTok, "tSigUSD", "test SigUSD", 2))
      .contract(owner.address.toErgoContract)
      .build()

    val tx = ctx.newTxBuilder().addInputs(box).addOutputs(out).fee(Parameters.MinFee).sendChangeTo(owner.address).build()
    owner.prover.sign(tx)
  }

  val fakeCurrency: ErgoId = ErgoId.create("0cd8c9f416e5b1ca9f986a7f10a84191dfb85941619e49e53c0dc30ebf83324b")

  val fakeAsset: ErgoId = ErgoId.create("50ee4923fb56e0d215ad49424d76c216be6f807908be3951045f9e0020fbee09")

  val fakeTxId: String = "a1086e447695dc8dcb79c0bf3b06ed715ccfa2b28ef44889ebfbda16c00ff34b"
}
