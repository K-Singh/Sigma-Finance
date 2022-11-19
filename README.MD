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

# Protocol
There are 4 main transactions which must be implemented from a frontend interface
in order to interact with the SigmaBonds protocol. There are also a number of known contract
addresses to interact with.

## Contract Addresses

### ERG-based bonds
Mainnet Order Contract:
`V93nRn9xAsArMMeCn4vn6rN3mwXW19fKFiUN61QV6AUh1ZbR6drunUwUhaFK7EGe5arHfYVTSVGcCxPod76QZmR7pEBNZy2WBPPTEwkQS3KAhd5dBmvUVwddPZLoQdbnaopK7MNkdL5sThzVGF2FtHhDCP1SJGSe2hjApoqDVcZzRqFrQGYfxknEMU1UTx4NxfHQiNhmooQF631XQRktADaiBWUsr1zUtfJ8u1QEotbK8Mbe62mSMhT6XBytCafhG9FaaVQAbgmZspGXthrtFCbXF7evWT7hXeQj8b57PA8iKzRMZRRn6BBwtLHygcANgXuH8CjLG5cDoRguSVTKAiaGxvtPrNWAytjhzdVJ2LfccP4qVmrKvve15ERq6j3Z8vCCm6Q193vKW1YtZj6qjiAaGLgDweG5ppnp6RumnF2cLch3vTAbGrNJdvm9sA7N2ikSVpKLWDQ8GKecxgVNCyMF1FxyGWmCP22PsBgSZ5u9arMY15vvcYizTGaemmraoRkDgmb6qdT398QQxeAP8HYudopfWkEkNCjhdVM7FzY8A1KGpbqUvo6i6EQL4BgRzNMjPmDK245pXF9XhD8GiHmvBLwmjp6DPr68Ucs`

Mainnet Bond Contract:
`QqJ2m5USZtD7qN5WLrrh5zSyzSPsJPw3HbK2gm55s9725yPTPmkG6tPhGYbZm3qUFyr5ubukU9RGtxuadTn5rcFNcSciEU21MY29GPqEt89n58azkWdiSKNKUsV8X31J2cnBTLeJ2ib1Qw1uyrNKvLT1YvK3Mwc5ct93LzscvVqk6P1g4UpjJBJA3cHQ6rzfoz2PRuUV4RqvNJQMERX59g7hxVS`

Testnet Order Contract:
`4292dmMfjqk9Sm6ntgKhSKHzG8iTfm2tWYPQnAudEcDkfVngR9hqa8PNHchAmZE2q93RqUUWFUkiesDe5z7RZrjaQ5VQLdgHvAe9BzwgQyqZ8SYjA7wHU6HS3y6pGG4kAy5RSWfiKWLpTRXLnneoi6c9BwQnjK6JCFvJUFPq4DpEV1ki7gSdfD4oJPM2RnahXJB1NAYmZjrxoQoQm44pNHG5EM6EdidGfoVyocPhspiNYgeFzFNzNw4LSXNZGeADSHf6YRMNCJpXVEnmj2dstbC6x1rupt79k1TV5hZmLHHmLEjKJvYko98RwGkNiawpMpM2C1qpZLUpqMMmxqAFYPMchTaWPS23Rw6qgA3HBegvH7oAysi9RHvWADZ3Pb3G2urm4cVgZFymaonrpg5S6xPCB9TaXb8bHNtxLaZrBMFTspspciJFcvYpXJpn54HZ4AYbjJqpf7dkitjgK86Yc7gsFY1kTGQioRM56K85z6Jsm9pUurnJs8mxytigbTjxfSvKkubCv5RucQ4muq2thUd727SS3TRW5N1jurjguFEUExiKMRsPfbndrr3wzSWcCQ1tvgAfJUNE8vhRacUDArXV2pfQSg2mHttF8tBT`

Testnet Bond Contract:
`3ZM11ALsWtNziuptzAoVjfmaCUnthKub6GSUsAQ566hdXKeLq4V53DBx4A96vz3jF2dRmDQwhya121W51Fq8z6MAvafmY2Sn9zPKUuLqVVPreHcSdYSUa2EqHP8kCPkFLR1XkjA4FkSBVenQjHU9qbZxh1eMi9TL59bwwATfYt2WsZdQmsVanU5cMLSk5rUwXEgdzeFC3PAMhsphxVFcjGZMKmSh`

### SIGUSD-based bonds:
Mainnet Order Contract:
`ddT2D6G9Gj2P9vvfX8EXQSJkstc5Epm9fxs1YUFv2VRKLqvHihxk8cT2kSUHdBeSUkpUSrjzHxPyg9gbMPehGdA2BB9E4UcEV6rrQ8oBhjgeMHBZNT5pYe6RxshVv83rkG1z2sf8p3FH2trcKZZxUDpWTBtvzk9z7rHWjJam7J7Rk6DrpEGm8zh9rXJ7tG5AFDzqmXWRMTSzUDC4uYmK4iaCjFPwwhXLkh43bHgKiggZSh2zir2frGino5xWvRiocrSBcWEbcdA8D7L83f8sqKuDJHDexPiggwUYUtsjMncZy5krTgeVFLfxzEEwe4ZrPs61eL8WSJwdA9U3WyBFZHzEzmq11AsaZCEzeoT2MJcYdqqCWiYwSRHFGWznsRjKn4wHNS4najD5dTp4qdf9BcXXoKqBYQcAyaB6hq5YTceAuUfDnW4BS9ZQjnKhhTRUL11N9oKkP9tfqtDNxxYZV7PjZbjGWrPjweAYixMQvX7UJrQj5pgbPtwuW6sVf3gquk3C8kiHai2qja4xyVQoVdZ3acJQCd2CoDMrj6jhboqfv98ngfmUMV6H9sNtE81oVznFYCSm372fyBpaWptQVT9RQ1NTL3wBAQ3kVxin6y6X8ruaJxkYZRQf7HJDNPPFbmzQQ7eLS31Agi9fCSgNkuB5CoX36KQVcKw9736AJq2vjNA5BgSrLacy2GnFExDqJqH6jsxoAhafhn3deGfvoDFaLif3yXoXvR9G6NhCgLKZErVKK1LGFtraeteDhvVAPXP5etGT6t6NNxUKMAuN7XEAexcPMVJL5ePoDtEmjxf5QMh65TtfPTRsim7yJ22wLmdFyiM5DWg`

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
- R7: Bond Maturity Height: `Int`

## Tx 2: Close Bond Order
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