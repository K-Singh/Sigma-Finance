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

### Extensions: Lender Based Bond Market
We can create extensions of the protocol which allow for lender-based bond markets. During order closing,
lender can mint an NFT, and set the lenderPK on the bond UTXO to be of some contract which allows spending
of the collateral or repayment by spending a box which contains the NFT. In this way, lenders can trade
the NFT to speculate on the value of the bond.

## UI
There is no official UI associated with SigmaBonds. Please be sure that any UI
interacting with the SigmaBonds protocol uses known contract addresses and is trusted. Frontend
developers who create a UI for SigmaBonds can get a 0.4% fee for their implementation.
To get the fee, add your address' `SigmaProp` as Context Variable 0 on the Open Order UTXO whenever
an open bond request is taken/spent by a lender. Additionally, add an output box under your address,
whose ERG / token value will contain exactly `(400 * principal) / 100000)` tokens / nanoERGs.
The UI fee output will be `OUTPUTS(3)`. `OUTPUTS(2)` will be the dev fee, with a value of `(500 * principal) / 100000)`

## Token
SigmaBonds has no plans to make a token, and likely never will.

## Fees
There is a 0.5% developer fee while using SigmaBonds, which is taken from the lender when an order is first closed.
An additional 0.4% may be taken by frontend developers who implement a UI for
SigmaBonds.

# Protocol
There are 4 main transactions which must be implemented from a frontend interface
in order to interact with the SigmaBonds protocol. There are also a number of known contract
addresses to interact with.

## Contract Addresses
#### NOTE: Will update this soon, not representing current contracts
### ERG-based bonds

Mainnet Order Contract:
`6e2MJgyvdiwRcydTVD1kzwqgCk2Hzwyw1mMZtXEMrkMcodbqyLteoYJr5nvL5ZqdhjY7FQcuRKAktBLu8pudgDxW8vJ2kAcwuVgDpeFC5euKUdBai6TbEFEozdQk9kySdKwVpg4c9phFNnvfYRUY2eFNrgv4bL1iQfgMvpkyeJDPrXmVPuKDzyGP2PQCokq4hS7MfPAg5SMi5nRpNcPnbXqC43itnC9qnqqeBMgnBb7sKESj1QywEzdGpwXXWtpf1sB6yPGDHY8xycdet3PjeX5yZobaoWFXuyDU9VtpuYckE11HGsvGx6iquAsuukJoWdFznpMLt3JruTpxmm4CJWk2Z452n9RYsdvVp6brBw3DRAdayrn49gbrsw5DPDne61yoyaLWY4X8JrgAVtniis9WrR6Wpoqxy39K8CZFCfb6gSorFcB7PRLkgoLcXQ1nJ6FkuzLPQio7C2geWdoopmFoMk8EiuuoCGwmRgRTMgKkC87yaqPL529DhDE4YC19Tiwk6jHzb8d4QmtYzce7ZDNrcTwKYm5EoTvjAoCt1pEjYt3FeUPtrLZwHvLTxMupMYykQ1bg3B7fTkunNr6JJQEBkYdvFbRDro2dFcJEzSvFCL2gh63P2iqECDY77tGaPikhw3NjV1Z3r9b`

Mainnet Bond Contract:
`QqJ2m5USZtD7qN5WLrrh5zSyzSPsJPw3HbK2gm55s9725yPTPmkG6tPhGYbZm3qUFyr5ubukU9RGtxuadTn5rcFNcSciEU21MY29GPqEt89n58azkWdiSKNKUsV8X31J2cnBTLeJ2ib1Qw1uyrNKvLT1YvK3Mwc5ct93LzscvVqk6P1g4UpjJBJA3cHQ6rzfoz2PRuUV4RqvNJQMERX59g7hxVS`

Testnet Order Contract:
`c6QBcJPfweCufUEreWEAgMhbBD22JTkfp5KSWWySFeVZKjnvYboTCMTu5En7HZqDtYUoenW9gKsjbWoeZjjXdpGCdM5xdSPu1WtswUym55xJSBcgBWTHL8ngBVwc2YGxM925sa8ECMLn5wGqKtzWvgpRrSF8uQ2bsNKbBMwaaheGnwkth4X4qYqgqqbgeV66fmF8H5Kp49tJHcuSKqV1R6eYZhsUydhyMb4BNt1RcWCi89drtRTCFRukSRJ3MCKATtHbR2wj9qA4AG7NFQ5Num2LiYbzUr35FmS382UCsebsqziTXcR3unmF4MwNUHJo3FFeQgSw1DmkRAaQnHoexydsa5CWKen9qoMfgNxsQLxFW1QkedsEr6xHtov6sqFmZy2iLscGcBiGjpHvsHaQSNADWyYtMgChxjXkWwSdRFvfHrJigSp9cjtMZYDbpG9XHfUkrdFDVrfNkPBiXsaynjK7b4ABBbxPufftdzgQ68rL7cV2HaKM742FY6rzsJKv31CvAZvaF21tE66ACkawmMcdDiXiqqUJf9Zt89QjmCEPvKVpvTopBUzAJovZTCpLbZF9oq2KpFbajtkxs4FmVcmBjYDEnN9y3x7GAj4oka1FmPi65DukNYccKP9ZnmMgBfuBUVc9uoe3Mmb`

Testnet Bond Contract:
`3ZM11ALsWtNziuptzAoVjfmaCUnthKub6GSUsAQ566hdXKeLq4V53DBx4A96vz3jF2dRmDQwhya121W51Fq8z6MAvafmY2Sn9zPKUuLqVVPreHcSdYSUa2EqHP8kCPkFLR1XkjA4FkSBVenQjHU9qbZxh1eMi9TL59bwwATfYt2WsZdQmsVanU5cMLSk5rUwXEgdzeFC3PAMhsphxVFcjGZMKmSh`

### SIGUSD-based bonds:
Mainnet Order Contract:
`8LgwK1K2uUfhde5TU82sGKYZtBuViicJoN9WMZhoPGENV8NP132p5jpHP8KBQjfxmwshARn8p2tiJwHAceUZF8DQotwaBnQCN7ar9YGeK37hZ1yEc4FV8MuNtt7Vd6481BR4BEwF4Cs1RLVepFCsErXyUDZCyoKzjSLVjVC8ttxmjJPscCEXSLYQNpZt9UgEV2gYcpE7aWm9GrUMT9PdtakGVbtitFxzdDpFPXwxKhfY23JXy1Q6xJbmrnyAynaZTAnAyxJ6DmoVKZEAfsTNxuSP8yiVvALt4QJffzkjaiTJ1MZWmU1w5vxsNL5F12dWfoPFY8UjuXevpvbqzmi6Gr6toZeusq89h8gGXsJqy5dpvHvL6FXvssXGThdQgjJVqgcbEcLH57uEaQ815dUxbSsWgoZ791vQSK9Wy9kXWCnqLSLGJZQMf5ePyvCizZJGUxfvon2MAoBt23jKVsTB4SakxUwFXPWJaeW3KTqQSKgXVYa4CETDENTb8iKJgBBa5XE7TF15rPTVda1z96eTsWLHmbdJfGaJPYZUKxrEDWwPTyreezwVs6W4fm7vnNr81fGs5vz5phEDKUGK2RbAcvAFn6eN1hgFDXuoRJCnuYZNqXVYPNxTm4Z5ej2wiwHovURiGxrfA4611PDfa5EJFQKqp8WFnuxiNA6vywkrJ7ZzH9Qfxnz5teGyqGDxqboEmKJjPxbxZ3xxGd3rMvr65M6wU3MPdBwYbdJkQZnCH1QjDiHm3j7bBzuZm37xDCvPEPygqYyvcxaQ3W5U5x6e3fGfx1Fpk9ZKxKotkq1WwjxBAMSiERphkCmzWfhEA7ydrjvHPj6227NP32gsTZmsvrygzacZGjFXurtt75drFvYnEvvLZkX`

Mainnet Bond Contract:
`XFSeH482qYDp7ARKE1b5R9cJpeW6UVEvNo541fdj617acRXr2SQBujYSNdWuRGMc6eFLFe9XpcEnse1JfDee615jWgFy1s2R3PnKp7oF64cK2FQCRZHJrG35R4w54efr15Ga9Yj4P1bURDLfGVdmnmBDJgiXmdc5EkVpL2BfqMMyrjsTk5DMeU6S6sNzRjKo19o755xT4DdQCnuv4p6bLgh8oLoBtPdLkhEtga4wjFRM9cW8LEdCWHM7ghVE2fGHWGNKuxUV4uBRza4bzkmhyuQcFV5VBb5SvSwDDhp1bmKKmvAm1K1NZJKfDmzWAAHw`

Testnet Order Contract:
`None`

Testnet Bond Contract:
`None`
## Tx 1: Open Bond Order
In this transaction, a borrower wishes to create a new bond request / order on the
blockchain. The borrower will send all the collateral (assets + ERG) they wish
to use for their bond to a utxo under the bond order contract. On this outputted UTXO, they
will set the following registers to record information about their potential bond.
- R4: Borrower's PK: `SigmaProp`
- R5: Bond Principal (In tokens / nanoERGs): `Long`
- R6: Total Repayment (In tokens / nanoERGs): `Long`
- R7: Maturity: `Int`

Bond Maturity comes in two different forms:
If maturity is of negative value, then it represents bond which expires a number of blocks after
closing of the order. In this case, value must be less than or equal to -30 (meaning minimum duration of 30 blocks).
We can call this an "On-Close" order.

If maturity is of positive value, then closing of the order ensures the bond expires at the exact
value stored in R7. We can call this a "Fixed Height" order.
## Tx 2: Close Bond Order
In this transaction, a lender has found a bond order they wish to fulfill by sending
the principal amount back to the borrower. The lender will first create a
bond contract utxo in `OUTPUTS(0)`. They will set the following registers on it:
- R4: Box id of originating order: `Coll[Byte]`
- R5: borrowerPK: `SigmaProp`
- R6: Total Repayment (In number of raw / non-decimaled SIGUSD tokens): `Long`
- R7: Bond Maturity Height (Height at which bond may be liquidated): `Int` 
- R8: lenderPK: `SigmaProp`

There are two ways to derive Bond Maturity Height, depending on the `maturity` stored in R7 of the Open
Order UTXO.

If `maturity` is negative (Is an "On-Close" order):
The bond maturity height is derived by taking the current height of the blockchain + abs(`maturity`)
on R7 of the Open Order input box. If a close bond tx is not confirmed within 8 blocks after being
sent to the mempool, the transaction may disappear.

If `maturity` is positive (Is a "Fixed Height" order):
Simply copy the value of `maturity` into the bond maturity height (So copying R7 of open order into R7 of
bond utxo).

At the same time, `OUTPUTS(1)` will have a utxo going to the borrower's PK, which
is holding the total principal amount specified by the borrower in R5 of the order contract.
If the principal is in tokens, the only value of ERG that can be accepted is `0.001`
## Tx 3: RePay Bond Order
Once a bond order has been fulfilled / closed, a bond utxo with specific information then exists on the blockchain. If the
borrower is able to get the repayment value in time before the maturity height is reached, they may perform
a repayment transaction. In this transaction, the repayment value is sent to the lender (must have `0.001` ERG in it if it
is a token-based bond) in `OUTPUTS(0)`. The collateral (Assets + ERG) held by the bond utxo is then returned to the borrower in
`OUTPUTS(1)`.

On `OUTPUTS(0)`, the following registers exist:
- R4: Box id of originating bond UTXO


Only the borrower may sign and initiate this transaction.
## Tx 4: Liquidate Bond Collateral
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