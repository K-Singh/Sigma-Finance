import org.ergoplatform.appkit.{BlockchainContext, NetworkType, RestApiErgoClient}

object ContractClient extends App{

  val networkType: NetworkType = NetworkType.TESTNET
  val nodePort:    String      = if(networkType == NetworkType.MAINNET) ":9053/" else ":9052/"

  val client = RestApiErgoClient.create(
    "http://213.239.193.208" + nodePort,
    networkType,
    "",
    RestApiErgoClient.getDefaultExplorerUrl(networkType))

  val tokenIds: Seq[String] = Seq() // Add token id strings here

  def printAddresses(ctx: BlockchainContext, optTokenId: Option[String]) = {
    val bondContract = ScriptGenerator.mkBondContract(ctx, optTokenId)
    val onClose      = ScriptGenerator.mkOrderContract(ctx, isFixed = false, optTokenId)
    val fixed        = ScriptGenerator.mkOrderContract(ctx, isFixed = true, optTokenId)

    val tokenId = optTokenId.getOrElse("ERG")

    println(s"Printing addresses for contracts using token ${tokenId}")

    println(s"Bond Contract: ${bondContract.toAddress}")
    println(s"On-Close Order: ${onClose.toAddress}")
    println(s"Fixed Height Order: ${fixed.toAddress}")
  }

  client.execute{
    ctx =>
      println(s"Using network type: ${networkType}")

      printAddresses(ctx, None)

      tokenIds.foreach{
        id =>
          printAddresses(ctx, Some(id))
      }


  }
}
