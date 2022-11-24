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


### ERG-based bonds

Mainnet Bond Contract:
`ZHMfprLmqmE3qq7LQdwCtr8KnC3kVGQczsDuMwFRgRG6xd5GtKMhT45Nk3soDtmfcyoVS1gbzf7bz77NgfjdtkyrSJ2X2dmoA32W5F9mrXNsjJcmee9DEfC9PwsSqAqDsZ7yMFFzcVpanARC4LuDcJLJjQVFmBJhBLLsdkfCrhxUFLbrgixjE2uzGVH1r7Q5yDPkyCPhZfbCakKi`

Mainnet Order Contract (On-Close):
`2jMoa21VMLebD9C3j1jXHBCSZitYqMdcqJt7jSKAVwAsVaKifkspA8jfSeRp2dnnQVgjdsXfRDz81sYLF6LnABUDrAr1QAedTtQFg5nShAqed7NRNdLTBXqwwYkr2o4nr1yGYWZKoivGaMdxpdZ2f5Hpx5iX5wXAnKnLpxd2SK5qBj7WaadasGpdeJUvJfGfN4Gs37gLVnKkdpuuUfNNETL1KFcdXbEBeqiRTBb7nx2woj1CMDnsrTun4MJe1kT5SDF9eEGXhXxmGaaFbociH2LBAkSS135tLsTSWY2VLnmKXVHaq3hQQvTwhpqRcAEW6iAykS3KffLNvt7vzgUt3pZ8yHgB3nWZ9nk6pZjnQwGu9ijLb2aXj8mpLmNVemzge8hWUJoDkFdE8Tp1VkhMHwzf492yJoJr3vzff9xE7Qow6kRXhYc2SQikhU6m2qCJMDYvp5xr1ruCmVoeas4HuBH3hJJNYVx1qg4uWremL6fKFFmhj7MBQQZDfBomQYEjtrStJbm2CyvQbjQR6RoyPesHSo4LGePzmBmBwgFsLfE9VrqLbBydoLDeYNxxkHxutK58SmCXcniXLA9NPMgfzT8aycLmPXvfEBYbDyBy6U1U7xpBPS1rnAH6XB8cwYwx1JQ`

Mainnet Order Contract (Fixed-Height):
`9drQ9RPn3p6hMfLBBffMoNSXzpa8eFpxz922UjQVKXWL8nyHNkRVhLWoKzkE8xWL9AHHHnh3HgoUrBWf3JeJpNJehmsHrkfcu8aG74in6m2Mxu5Ba7GoiooQZmTr5zuevw298wU4AEnxQKpLFxi4U4U86vnvABTxKDDBmbDyetV87MyGw4QTynuCP4vUUyKqZhrqYptTVdPY9woK97h3tyCtFmx1xk67ieRnmtNjG1Ter3L957ZZGEz2UYeCMfGbP6dMpr2HiK2UBR9vwiUXzCnkh6hmVRjaLyNLTbwmqxKsdGPD6uwnqrLiJxpCx4LV77HpsePBpgkVPLdvqW4fpjh4UTeqthHMEnwh6s41nK5LXPKhVyw8t8AADcrNq9SMs8Bf7cSeDMcdhq4xGES2zku9EBKcJaDcQYh2Uv6MsuijMVP2tVhoLrHjZN65W2VJJU7P46UmgNiaNeGXdpZRkwxidRXUaqaDtyJkofA5hxAtjbgYfa9AUvXj7WHkk3hbeu9aN9RnMjVpJptVZ5Pjb3Hzmn5fypXFfLdBvENoSYTSg5Fk7hoixFi4D8yMrRMmAk9JdDm6bT44DUVSgSBicFnmocA`


Testnet Bond Contract:
`4TwNASK7pbxYLmVWa2Xo7BSpfq2aiuLtYX7XWtA3Y1iwSZU8a4NpViuVQakJmtUqqi7YX5T6B58C9TFgjhx1FNHVR4UxwXzVR22haFAhMT16eg1HyZkJpRHbhaFpaZ6Kbz3BLYtqR6oVhKvrmBkzv69St6vGjG9BekxfevL8AXVwTSGFRTnP7DNMYZLESKSLJuwGThLoWqU4ouC6J`

Testnet Order Contract (On-Close):
`BmdoLSSvWwhomZRj9YeShBGzjLfTvaojnCtxciMHS4KGFCChagixkFRfc4XFtA8C2dBsQuqe6UUBgCHN8HNYSPVgB7PHRhfXzhCD1WoB9jHzyECzPzN1GN1PBep9BNvN8QbAUsZFXEPi5uQuxHJvPnyYBrZocSZUrQ9s8eVeerW3vgWcvaTZHEY4faHewxPcwcxvsiPFa2rPCp1xCQu63z5Acjm9eeJSpDNxyBmjNdr2VwThCJKrWTr3H4t4qM71DzoCewKeibfRN1gNK6oPAk9EN63t1ova2efbexNz4PHzDfUUtjWZ1scbeHKrNnb6kqSwjurFKamXyGbUHhTnzqQHnks3KL87f6Z5Gwk5RCagHmeiNeJQfn15yCbCwRgtAK2RQxKmW2sbmuZSVsmSZztwj8KCFuRRn8VwMRP7cPbqi8HikpX3NU57rGApMFsjKpafhaWkjgCGfhiVnvrVo4ys1DsTsakLHP4NGyd6zUJG2zk42PaTTm7s6wd4mxrZu3hLNzLy9G22GZk29A2f4BRhFze4WKsBADNaRao8i4kAZjbY6avEVkUbvvbiG5KWnaPTSu6GTx3XZZj7K3ae6N6Zvegu1DXhienFNPKaX3dj5YsE6PoWK85LtYSwioLYzJU`

Testnet Order Contract (Fixed-Height):
`vkMLPhPPSJhewd4uLSmBLvxuBWgFn2sAChDEX7TmfbHeuv42oViHvAwvzsADbRDUM6ywXF8DUp3Wjk8robmwNBctVSX9cucuV1WskPmpYDCkP9bbLkeqKN1SRs4HutheGNjda5TWfXEdwZqiMs6LXQVe168kBX8bn3LiNyifuMsJst4jQJKFVu3aCJRG4ueLr6eUKCKKNv5JhTJPAtRXzgauwps4SLtUyyALoe8brQWPCPuVoSFVaSPop5fzxt4vaLfL1pGUmmRQnrxpiiLNEC7u1LD5nYkMcZjGmRsM89fbW3wxwwAQw71MEmdMpudLkoRz1uN8eU4ABzqAJEqtFS1fDvM82tuhQSnFF8ZPa3ux8q21MRZhBp6hhP3XHD1cdQXjZ5tf6VdKoo4GKZZPZk7oAD715nPFFqoAhbtcbXbc6pfvS4RJdUMk74TbkxQEAzFmsjDtxwNUTrHM62SnRELjMqoAtgfQWSVWqKiLug49gpELkEBQw7Ehr576oXQjZXHLmmprxuk3W3sU1tUBzbCNzAMJUVkoFa5v7aMQxkuqyYgywFBJV7CJb4nLpyECrxwP8aAMMnQSvGoxXFsrFHa9oRv`

### SIGUSD-based bonds:
#### NOTE: Add later
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
If order is of "OnClose" type, then it represents bond which expires a number of blocks after
closing of the order. In this case, value must be greater than or equal to 30 (meaning minimum duration of 30 blocks).


If order is of "FixedHeight" type, then the
value stored in maturity is copied into R7 of the bond box.
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

If `maturity` is on an "On-Close" order:
The bond maturity height is derived by taking the current height of the blockchain + `maturity`
on R7 of the Open Order input box. If a close bond tx is not confirmed within 8 blocks after being
sent to the mempool, the transaction may disappear.

If `maturity` is on a "Fixed Height" order:
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