package ksingh.sigmabonds
package bonds

import ksingh.sigmabonds.bonds.BondGenerator.toInput
import org.scalatest.funsuite.AnyFunSuite
import ksingh.sigmabonds.bonds.TestHelper._
import org.ergoplatform.appkit.{ErgoId, ErgoToken, Parameters}
import org.ergoplatform.appkit.scalaapi.ErgoValueBuilder
import sigmastate.eval.CostingSigmaDslBuilder.Colls


class BondTestSuite extends AnyFunSuite{
  test("Make Bond Order"){

    client.execute{
      ctx =>
        val out = BondGenerator.makeOrderBox(ctx, Parameters.OneErg * 5, Seq(), Some(fakeAsset),
          isFixed = true, seller, 5000L, 10000L,  137178)

        val in = toInput(walletBox(ctx, seller, Parameters.OneErg*10))

        val tx = ctx.newTxBuilder()
          .addInputs(in)
          .addOutputs(out)
          .fee(Parameters.MinFee)
          .sendChangeTo(seller.address)
          .build()

        val sTx = seller.prover.sign(tx)

        println(sTx.toJson(true))
        //ctx.sendTransaction(sTx)

    }

  }

  test("Make Bond Offer"){
    client.execute{
      ctx =>
        val out = BondGenerator.makeOfferBox(ctx, Parameters.OneErg * 5, Seq(), None, true, buyer, Parameters.OneErg * 6,
          Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 1L)),137178)

        val in = toInput(walletBox(ctx, buyer, Parameters.OneErg*10))

        val tx = ctx.newTxBuilder()
          .addInputs(in)
          .addOutputs(out)
          .fee(Parameters.MinFee)
          .sendChangeTo(buyer.address)
          .build()

        val sTx = buyer.prover.sign(tx)

        println(sTx.toJson(true))
      //ctx.sendTransaction(sTx)

    }
  }

  test("Close Bond Offer"){
    client.execute{
      ctx =>

        val offerBox = toInput(BondGenerator.makeOfferBox(ctx, Parameters.MinFee, Seq(new ErgoToken(fakeCurrency, 1)), Some(fakeCurrency), true, buyer, Parameters.OneErg * 6,
          Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 1L)),137178))
        //val orderBox = ctx.getBoxesById("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e").head

        val borrowerInput = toInput(walletBox(ctx, seller, 2 * Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 1L))))

        val outBondBox = BondGenerator.makeBondBox(ctx, Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 1L)), Some(fakeCurrency), isFixed = true,
          offerBox.getId, seller, buyer, Parameters.OneErg * 6, 137178)

        val outLoan = walletBox(ctx, seller, Parameters.MinFee, Seq(new ErgoToken(fakeCurrency, 1)))

       // val outFee = walletBox(ctx, dev, (0.005 * Parameters.OneErg * 5).toLong, Seq())

        val tx = ctx.newTxBuilder()
          .addInputs(offerBox, borrowerInput)
          .addOutputs(outBondBox, outLoan)
          .fee(Parameters.MinFee)
          .sendChangeTo(seller.address)
          .build()

        val signTx = seller.prover.sign(tx)

        println(signTx.toJson(true, true))

      //ctx.sendTransaction(signTx)
    }
  }



  // Tx Id: 086c43ff415cd735617247bb8e237567c994662e5399cb615bda5d27bf2e24cc - Testnet
  test("Closing Bond Order"){
      client.execute{
        ctx =>

          val orderBox = toInput(BondGenerator.makeOrderBox(ctx, Parameters.OneErg * 10, Seq(), Some(fakeAsset),
            isFixed = true, seller, 5000L, 10000L,  137178))
          //val orderBox = ctx.getBoxesById("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e").head

          val lenderInput = toInput(walletBox(ctx, buyer, 5 * Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 5050L))))

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

          //ctx.sendTransaction(signTx)
      }

  }

  test("Liquidating Bond"){
    client.execute{
      ctx =>
        val bondBox = toInput(BondGenerator.makeBondBox(ctx, Parameters.OneErg / 4, Seq(), Some(fakeAsset), isFixed = true,
          ErgoId.create("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e"), seller, buyer, 10000L, 137178))
        val changeBox = toInput(walletBox(ctx, buyer, 5*Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 10000L))))
        val outLiquidated = ctx.newTxBuilder().outBoxBuilder()
          .value(Parameters.OneErg / 4)
          .contract(buyer.address.toErgoContract)
          .registers(
            ErgoValueBuilder.buildFor(Colls.fromArray(bondBox.getId.getBytes))
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

       // ctx.sendTransaction(sTx)

    }

  }

  test("Closing Bond"){
    client.execute{
      ctx =>
        val bondBox = toInput(BondGenerator.makeBondBox(ctx, Parameters.OneErg / 4, Seq(), Some(fakeAsset), isFixed = true,
          ErgoId.create("a360ed9afc76ee0cecaa628aa5639bfb8946e114ca11d5982e3a7b2e8143093e"), seller, buyer, 10000L, 10000000))
        val changeBox = toInput(walletBox(ctx, seller, 5*Parameters.OneErg, Seq(new ErgoToken(fakeAsset, 10000L))))
        val outClosed = ctx.newTxBuilder().outBoxBuilder()
          .value(Parameters.MinFee)
          .contract(buyer.address.toErgoContract)
          .tokens(new ErgoToken(fakeAsset, 10000L))
          .registers(
            ErgoValueBuilder.buildFor(Colls.fromArray(bondBox.getId.getBytes))
          )
          .build()

        val outCollat = walletBox(ctx, seller, Parameters.OneErg / 4)

        val tx = ctx.newTxBuilder()
          .addInputs(bondBox, changeBox)
          .addOutputs(outClosed, outCollat)
          .fee(Parameters.MinFee)
          .sendChangeTo(buyer.address)
          .build()

        val sTx = seller.prover.sign(tx)

        println(sTx.toJson(true, true))

      // ctx.sendTransaction(sTx)

    }

  }
}
