package ksingh.sigmabonds
package bonds

import client.ScriptGenerator

import ksingh.sigmabonds.bonds.TestHelper.{Party, dev}
import org.ergoplatform.appkit.scalaapi.ErgoValueBuilder
import org.ergoplatform.appkit.{BlockchainContext, ErgoId, ErgoToken, ErgoValue, InputBox, OutBox}
import scalan.RType
import sigmastate.eval.CostingSigmaDslBuilder.Colls

object BondGenerator {

  def makeOrderBox(ctx: BlockchainContext, value: Long, tokens: Seq[ErgoToken],
                   optTokenId: Option[ErgoId] = None, isFixed: Boolean = true,
                   borrower: Party, principal: Long, repayment: Long, maturity: Int): OutBox = {
    val box = ctx.newTxBuilder().outBoxBuilder()
      .value(value)

      .contract(ScriptGenerator.mkOrderContract(ctx, isFixed, optTokenId.map(_.toString), dev.address.getPublicKey))
      .registers(
        ErgoValue.of(borrower.address.getPublicKey),
        ErgoValue.of(principal),
        ErgoValue.of(repayment),
        ErgoValue.of(maturity),
      )

      if(tokens.nonEmpty)
        box.tokens(tokens:_*)

      box.build()
  }

  def makeOfferBox(ctx: BlockchainContext, principal: Long, tokens: Seq[ErgoToken],
                   optTokenId: Option[ErgoId] = None, isFixed: Boolean = true,
                   lender: Party, repayment: Long, collateralErg: Long, collateralAssets: Seq[ErgoToken], maturity: Int): OutBox = {
    val box = ctx.newTxBuilder().outBoxBuilder()
      .value(principal)

      .contract(ScriptGenerator.mkOfferContract(ctx, isFixed, optTokenId.map(_.toString), dev.address.getPublicKey))
      .registers(
        ErgoValue.of(lender.address.getPublicKey),
        ErgoValue.of(collateralErg),
        ErgoValueBuilder.buildFor(Colls.fromArray(collateralAssets.map(c => Colls.fromArray(c.getId.getBytes) -> c.getValue).toArray)),
        ErgoValue.of(repayment),
        ErgoValue.of(maturity),
      )

    if(tokens.nonEmpty)
      box.tokens(tokens:_*)

    box.build()
  }

  def makeBondBox(ctx: BlockchainContext, value: Long, tokens: Seq[ErgoToken],
                  optTokenId: Option[ErgoId] = None, isFixed: Boolean = true,
                  lastBoxId: ErgoId, borrower: Party, lender: Party, repayment: Long, maturityHeight: Int): OutBox = {
    val box = ctx.newTxBuilder().outBoxBuilder()
      .value(value)

      .contract(ScriptGenerator.mkBondContract(ctx, optTokenId.map(_.toString)))
      .registers(
        ErgoValueBuilder.buildFor(Colls.fromArray(lastBoxId.getBytes)),
        ErgoValue.of(borrower.address.getPublicKey),
        ErgoValueBuilder.buildFor(repayment),
        ErgoValueBuilder.buildFor(maturityHeight),
        ErgoValue.of(lender.address.getPublicKey)
      )
    if(tokens.nonEmpty)
      box.tokens(tokens:_*)

    box.build()

  }

  def toInput(outBox: OutBox) = outBox.convertToInputWith(TestHelper.fakeTxId, 0.toShort)
}
