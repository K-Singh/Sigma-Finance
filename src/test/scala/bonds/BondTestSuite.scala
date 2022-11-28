package ksingh.sigmabonds
package bonds

import ksingh.sigmabonds.bonds.BondGenerator.toInput
import org.scalatest.funsuite.AnyFunSuite
import ksingh.sigmabonds.bonds.TestHelper._
import org.ergoplatform.appkit.{ErgoId, Parameters}
import org.ergoplatform.appkit.scalaapi.ErgoValueBuilder
import sigmastate.eval.CostingSigmaDslBuilder.Colls


class BondTestSuite extends AnyFunSuite{
  test("Make Bond Order"){

    client.execute{
      ctx =>
        val out = BondGenerator.makeOrderBox(ctx, Parameters.OneErg * 5, Seq(), Some(fakeAsset),
          isFixed = true, seller, 5000L, 10000L,  137178)

        val in = ctx.getBoxesById("70fac5fb0f7621d50cc73464a5fb4b10cb139a5954b87c3824da8e80fc67fc8e").head

        val tx = ctx.newTxBuilder()
          .addInputs(in)
          .addOutputs(out)
          .fee(Parameters.MinFee)
          .sendChangeTo(seller.address)
          .build()

        val sTx = seller.prover.sign(tx)

        println(sTx.toJson(true))
        ctx.sendTransaction(sTx)

    }

  }
  // Tx Id: 086c43ff415cd735617247bb8e237567c994662e5399cb615bda5d27bf2e24cc - Testnet
  test("Closing Bond Order"){
      client.execute{
        ctx =>

//          val orderBox = toInput(BondGenerator.makeOrderBox(ctx, Parameters.OneErg * 10, Seq(), Some(fakeAsset),
//            isFixed = true, seller, 5000L, 10000L,  137178))
          //val orderBox = ctx.getBoxesById("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e").head

          val lenderInput = ctx.getBoxesById("202d88c0c33b29548bbbeebd39de85ce838b4caaf91f4398c419663514858a67").head

          val outBondBox = BondGenerator.makeBondBox(ctx, Parameters.OneErg / 4, Seq(), Some(fakeAsset), isFixed = true,
            ErgoId.create("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e"), seller, buyer, 10000L, 137178)

          val outLoan = walletBox(ctx, seller, Parameters.MinFee, Seq(token(fakeAsset, 5000L)))

          val outFee = walletBox(ctx, dev, Parameters.MinFee, Seq(token(fakeAsset, (5000L * 500) / 100000L)))

          val tx = ctx.newTxBuilder()
            .addInputs(lenderInput)
            .addOutputs(outBondBox, outLoan, outFee)
            .fee(Parameters.MinFee)
            .sendChangeTo(buyer.address)
            .build()

          val signTx = buyer.prover.sign(tx)

          println(signTx.toJson(true, true))

          ctx.sendTransaction(signTx)
      }

  }

  test("Liquidating Bond"){
    client.execute{
      ctx =>
        val bondBox = ctx.getBoxesById("52c4d1520a08a500f8ae57a17eabb40477c98625bfb6c0bd8f98925141ec5c03").head
        val changeBox = ctx.getBoxesById("73368e056d13fb90d7c191c8f7bbcaf6824ecfdaed5656adcf4b830de9396f30").head
        val outLiquidated = ctx.newTxBuilder().outBoxBuilder()
          .value(Parameters.OneErg / 4)
          .contract(buyer.address.toErgoContract)
          .registers(
            ErgoValueBuilder.buildFor(Colls.fromArray(ErgoId.create("52c4d1520a08a500f8ae57a17eabb40477c98625bfb6c0bd8f98925141ec5c03").getBytes))
          )
          .build()

        val tx = ctx.newTxBuilder()
          .addInputs(bondBox, changeBox)
          .addOutputs(outLiquidated)
          .fee(Parameters.MinFee)
          .sendChangeTo(buyer.address)
          .build()

        val sTx = buyer.prover.sign(tx)

        println(sTx.toJson(true, true))

        ctx.sendTransaction(sTx)

    }

  }
}
