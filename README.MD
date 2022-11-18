# SigmaBonds

SigmaBonds is a decentralized, P2P bond protocol built on the Ergo blockchain.
SigmaBonds allows borrowers to create bond requests in which they set the
maturity date, APY, principal amount, and collateral. Lenders may then view
all the available bond requests on the blockchain in order to decide where they
wish to place their money. SigmaBonds may be collateralized by *any* asset available
on the Ergo blockchain. That includes ERG, tokens (like SIGUSD, Ergopad, Neta, etc.), and
NFTs. Moreover, borrowers may use any combination of the above in a single bond, allowing
for more flexible collateralization methods.


## Utility
SigmaBonds can be used for a variety of different purposes, including the raising of funds,
access to quick liquid assets, improvements to mining rigs/farms,
arbitrage opportunities, and many other unique DeFi usecases. For lenders, SigmaBonds
can be used to slowly gain yield on ERG or a native asset of their choice. Flexibility in collateralization also allows
for lenders to have more options when evaluating loans (e.g. A lender may be willing to take less collateral
from entities they deem to be "trusted". Borrower identities can be verified via Public Key or ErgoNames).

## UI
There is no official UI associated with SigmaBonds. Please be sure that any UI
interacting with the SigmaBonds protocol uses known contract addresses and is trusted. Frontend
developers who create a UI for SigmaBonds can get a 0.4% fee for their implementation.
To get the fee, add your address' `SigmaProp` as Context Variable 0 on the Open Order UTXO whenever
an open bond request is taken/spent by a lender.

## Token
SigmaBonds has no plans to make a token, and likely never will.

## Fees
There is a 0.5% developer fee while using SigmaBonds, which is taken from the lender when an order is first closed.
An additional 0.4% may be taken by frontend developers who implement a UI for
SigmaBonds.

## Protocol
There are 4 main transactions which must be implemented from a frontend interface
in order to interact with the SigmaBonds protocol.

# Tx 1: Open Bond Order
In this transaction, a borrower wishes to create a new bond request / order on the
blockchain. The borrower will send all the collateral (assets + ERG) they wish
to use for their bond to a utxo under the bond order contract. On this outputted UTXO, they
will set the following registers to record information about their potential bond.
- R4: Borrower's PK: `SigmaProp`
- R5: Bond Principal (In tokens / nanoERGs): `Long`
- R6: Total Repayment (In tokens / nanoERGs): `Long`
- R7: Bond Maturity Height: `Int`

# Tx 2: Close Bond Order
In this transaction, a lender has found a bond order they wish to fulfill by sending
the principal amount back to the borrower. The lender will first create a
bond contract utxo in `OUTPUTS(0)`. They will set the following registers on it:
- R4: Box id of originating order: `Coll[Byte]`
- R5: borrowerPK: `SigmaProp`
- R6: Total Repayment (In number of raw / non-decimaled SIGUSD tokens): `Long`
- R7: Bond Maturity Height: `Int`
- R8: lenderPK: `SigmaProp`

At the same time, `OUTPUTS(1)` will have a utxo going to the borrower's PK, which
is holding the total principal amount specified by the borrower in R5 of the order contract.
If the principal is in tokens, the only value of ERG that can be accepted is `0.001`
# Tx 3: RePay Bond Order
Once a bond order has been fulfilled / closed, a bond utxo with specific information then exists on the blockchain. If the
borrower is able to get the repayment value in time before the maturity height is reached, they may perform
a repayment transaction. In this transaction, the repayment value is sent to the lender (must have `0.001` ERG in it if it
is a token-based bond) in `OUTPUTS(0)`. The collateral (Assets + ERG) held by the bond utxo is then returned to the borrower in
`OUTPUTS(1)`.

On `OUTPUTS(0)`, the following registers exist:
- R4: Box id of originating bond UTXO


Only the borrower may sign and initiate this transaction.
# Tx 4: Liquidate Bond Collateral
In the case that a borrower does not repay their bond order by the maturity height, the lender may
sign and initiate a liquidation transaction. In this transaction, the total amount of collateral held in
the bond utxo is all sent to the lender's PK in `OUTPUTS(0)`.
On `OUTPUTS(0)`, the following registers exist:
- R4: Box id of originating bond UTXO


## KYA / Note To Users
Lenders should always be wary to ensure that the bond orders they accept match
their own personal risk/reward ratio. Lenders of NFT-backed loans should also
be sure that the NFTs used as collateral are real and minted by their original artists.
The creator of SigmaBonds is not responsible for the gain/loss of any digital
assets and/or perceived value incurred through the use of SigmaBonds.