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
`2f7L4F3Q9eCjdWRmxSENw18Bw5SPAf3vBaimRqgpWB5JayiqSWG2tvnc6kF8ae8mpYwtZasmVDzmgjbfa8EBTdA1u55yB8ypRZDDFhs6DmhQekuGvzBoViApMyKdAXCPriXMaJWgHxAdjtR7QhXSjdnyozxZ7ApXrQY6hDSX6H2Fg9siuGUQpTQ3oJDa8nScMGdLNK2T5A7oHs`

Mainnet Order Contract (On-Close):
`2jMoa21VMLebD9C3j1jXHBCSZitYqMdcqJt7jSKAVwAsVaKifkspA8jfSeRp2dnnQVgjdsXfRDzo4h1hmroTnPsMAB8qiBnyGjStmMxxFirroejmZFgH25zouApdAZtjTERNrvn67QFPGhGRpxopGEZYrQbpj3PmNR4UPyvKkCHzWbkM7cMA2o45RadU4gY6LAoDwvop35QmPsbP2CuETfJPWUKHgDw87wzwPfpBHYxNht3btUuaNB7ifL1To8KotbFKQyRQ3s84vsbed5abchfWhgSkU6HDvJJM9vmt2axcC5P72jEtPsdK19oGw3FsYZp5S9DpKmQRJasDStTRtgBEbD6vnP6orTrje9oJEpvarFdRE9gG1gQKoQdUn5PtssaVhWG3yX67BSyy1mQVkdPq17CrD4di6mhuakBKi9Wn6YTFCvdeLqfSTAaFJPA3uitsqpSkLxNGyqMMtHZ5oahuZ3jVtx3As5N2ZTt835XUYsFE31n3CzfZPvyHCDtahYTRqeCBvPMZw8vdh3a1XtfqNX15AmQy7Jf8W6Y7McsKQVwG5gogXu6XSSCrGn9r2j9m3DBPitUPpEdNqavvxX5Jqrrp2UNLNNfsZZRT26ifnWWa1W5LnjVQVeRFdki5Haf`

Mainnet Order Contract (Fixed-Height):
`9drQ9RPn3p6hMfLBBffMoNSXzpa8eFpxz922UjQVKXWL8nyHNkRVhLWoKzkE8xWL9AHHHnh3HgrqjC9XjVu7KR4gL1fnrVWcQcrHiUSAEacsUNvkwFCy9xoG52UTAbj3jJyvkhNQg2h2RV86CniFXEsS6bRDcAdTAN8ytLLMAuE3DcMjgntsXeyVwrGRWYrktmtm6xCVAYnFRJhopAUTmYqGEmE2FnpC9uuqvG2bVR9xvngZJ1SxZzti7XnhsW6pSvMBLbVNcbGCJp3STHkrNU2QGV6WsgcHcif6aSMpnjQ26E1v3LMQ75RkWSU2RYnkKS8bbwQmAPrLTcnsC87Gj4gMTf1Agz62Smh7emvXUVqMYmfCF8yah3WthGsWUJb5jGa2VdAFoB7UyB7ksg4MYBPKX6QhCWsEuNjS2WJY6ZAVPtiU3cJbAmMqpqhY1FExJD4tXA1A7B3yTwFrq2epWdoHuSLewCpubNmJSXn5EVRiW6JN8vz5U1P4Jk4R4sRZBKtz2PFu53HEEgvc1TjGZ8sQA96mh74h26zEA3kWUEv6tP8pyFQYByr9xLARgngVNNXk6Hz8UFyyBt3xNr9kxNtA5hh`


Testnet Bond Contract:
`4TwNASK7pbxYLmVWa2Xo7BSpfq2aiuLtYX7XWtA3Y1iwSZU8a4NpViuVQakJmtUqqi7YX5T6B58C9TFgjhx1FNHVR4UxwXzVR22haFAhMT16eg1HyZkJpRHbhaFpaZ6Kbz3BLYtqR6oVhKvrmBkzv69St6vGjG9BekxfevL8AXVwTSGFRTnP7DNMYZLESKSLJuwGThLoWqU4ouC6J`

Testnet Order Contract (On-Close):
`BmdoLSSvWwhomZRj9YeShBGzjLfTvaojnCtxciMHS4KGFCChagixkFRfc4XFtA8C2dBsQuqe6UUBgCHN8HNYSPVgB7PHRhfXzhCD1WoB9jHzyECzPzN1GN1PBep9BNvN8QbAUsZFXEPi5uQuxHJvPnyYBrZocSZUrQ9s8eVeerW3vgWcvaTZHEY4faHewxPcwcxvsiPFa2rPCp1xCQu63z5Acjm9eeJSpDNxyBmjNdr2VwThCJKrWTr3H4t4qM71DzoCewKeibfRN1gNK6oPAk9EN63t1ova2efbexNz4PHzDfUUtjWZ1scbeHKrNnb6kqSwjurFKamXyGbUHhTnzqQHnks3KL87f6Z5Gwk5RCagHmeiNeJQfn15yCbCwRgtAK2RQxKmW2sbmuZSVsmSZztwj8KCFuRRn8VwMRP7cPbqi8HikpX3NU57rGApMFsjKpafhaWkjgCGfhiVnvrVo4ys1DsTsakLHP4NGyd6zUJG2zk42PaTTm7s6wd4mxrZu3hLNzLy9G22GZk29A2f4BRhFze4WKsBADNaRao8i4kAZjbY6avEVkUbvvbiG5KWnaPTSu6GTx3XZZj7K3ae6N6Zvegu1DXhienFNPKaX3dj5YsE6PoWK85LtYSwioLYzJU`

Testnet Order Contract (Fixed-Height):
`vkMLPhPPSJhewd4uLSmBLvxuBWgFn2sAChDEX7TmfbHeuv42oViHvAwvzsADbRDUM6ywXF8DUp3Wjk8robmwNBctVSX9cucuV1WskPmpYDCkP9bbLkeqKN1SRs4HutheGNjda5TWfXEdwZqiMs6LXQVe168kBX8bn3LiNyifuMsJst4jQJKFVu3aCJRG4ueLr6eUKCKKNv5JhTJPAtRXzgauwps4SLtUyyALoe8brQWPCPuVoSFVaSPop5fzxt4vaLfL1pGUmmRQnrxpiiLNEC7u1LD5nYkMcZjGmRsM89fbW3wxwwAQw71MEmdMpudLkoRz1uN8eU4ABzqAJEqtFS1fDvM82tuhQSnFF8ZPa3ux8q21MRZhBp6hhP3XHD1cdQXjZ5tf6VdKoo4GKZZPZk7oAD715nPFFqoAhbtcbXbc6pfvS4RJdUMk74TbkxQEAzFmsjDtxwNUTrHM62SnRELjMqoAtgfQWSVWqKiLug49gpELkEBQw7Ehr576oXQjZXHLmmprxuk3W3sU1tUBzbCNzAMJUVkoFa5v7aMQxkuqyYgywFBJV7CJb4nLpyECrxwP8aAMMnQSvGoxXFsrFHa9oRv`

### SIGUSD-based bonds:
Mainnet Bond Contract:
`47r8CNpYJhLaJy9vQAyyhVX7SLu73dg8EDmi9zzei7YWomvTAbNaZMAHdM38TsFoiZfAcKuyrgngD6ZS2uPQktLfFpvypxkRiRi9LswRYd5tk6B5HHDsFNMfLcdqeWT9RDR2SRq1zm2HF9F913aY1gc9gVyeh8PGED2ThKJ2NCG19XhyPqCbgTFY5uTC6RaqpGCdH9p58fD4DWDd46D3EfUXz3XLzqGQvDGXTghkh9UtZ1LB7nFFoPDFc2QVDt6BCtTQwq4Jh9vFfTfBG9q6ReVF5cVX7nA6vXhWjUuHKMd7Zw5anM2u95e`

Mainnet Order Contract (On-Close):
`3FdyuY8fqeTtYcsuvTsmsw4ZBGde2cad6hyntGxzSY3rd4JtTwTvK64xp3XJZvYNTijrTMZMQxkFiULuHpq46VFbAiSSHXLe1qy5WXNRELj4tcx6wEPbSDqzDyVbY6wKFQhmvYQT2XjqLJAiBGV9F6f2uXrjXFPzPnXpVeJnWc8ob1wMqbfgBQKdfu24qx3pejkAfAz2hmQQ57xgzGwHCcGyJdad7UxwmDetAUER8iwE32rygGCmqXaVeKGcJ33epYNGpDLPnYUg3Qz7eYuHHb7mAqwkEp6XGE1jWbf8nS7TA1taNpakssbWYN2YmB9NBG8nWNzLhc9QBdqyAn9WQ63Jh1znt2up6sQJR7xnon9ZsYoeo7bErzg4uoJbTLzwjhZBJ9En9bMX72xUb5zhvSSua6CseMMA6s86g2mwrieRwqFM7CGDypy78MzWS1nagUBKLet8LAFFpb6DKBK1h2HpAvLnMbWB7Kp3rJ4be6ed5crNdZTqhbSww96P2KNSZemhwfgAkUFjMJzB2dEG9VNAW1dMk5nBrS8JsRHhYpPqFcJiFtQvcar1ijs2PqsR9k4P41Y99iomfYXkSoA6z612v1U1C19ASVurzuxGP1vNwNyKLceFVTYXbgkgUFX8Z2nwMz6d2TCa4XTpt9daV5sBV88YJgCiYbL5QhxnoTdYRZbxu725jnV7gbnX9FWjLNaXYJubi5u8kPs3MYzSALeUvtfx6wJV1XyBn5DMbvy8XgFFMKyxtUrfU3dAVaZmUZJnYy8Dz6qrf8tyKx3uU7RfosjV7rcAFRDpozznWRfsxZUir5EzcVFQc9NbjB4HdgJxxvUJ9Nr9F8XCQLL89wCTtaNZBFF284qLtrQ`

Mainnet Order Contract (Fixed-Height):
`CExp7TDXwCNoFe5Ad3Mbiwkwd5Y9y9JmKPftycdMuwfUUy8WbaAfAr6kjSQWTK53LPrvEemmdnwMXWrKYpfhhnPMfFEA1c8nSdxdZ93V2HTMtKLFPscG4cwUCiw7Xg4g31UbLT2PkTUtkRBqsaiEUn8mU1hf5jNUoB9DwzbcBVaoHn7xWS3wrTFYJFU4bdD3Qstm88Yj3YZ86iC8Sq31ScQbCP7xrvyZPk7tAWhJehT7Hq5LWwHHeeGifjK4AEhXQe4qgzdGphPntYpySZcd94eCLbdB91YzfgirtkVBQaxA24WyX2Hxq5iwUha3JM5WCxkvoxEFZdujNVncsiafRWsvinAgAJAgk4SK55CgqzETo4smphqUVKzZYgYxGTcWfhqRh31Ly8BXwCc3EywRwPbSe56PjoJmXidcoY57CbG2LUutnDnQf2Q9jMCfGnmbgXDrz4mJNuw8wDaZXtkcHFKkTMLpB2xfJQgS2NtVsRxHL5qFrrrP9f18meiiE4rE1cSWzxSqJfxriyfho91j8xDJiLg1moaZuwnN9V5LQ4uLJ8u3wyxSfV8xRzufudRHbJ8L936G9rZ3RybJeFL35SBwnkZ3jfWnmKb9xRoyYicHHVmLRB8Z4bja9GeNk1EnerTasv7gTHrGDKgsdkLYN4Atg9NqTbbnyM8gTyn6wbWetxwMHNoeMHnA63kCceuS4xM9wrD1U6dXQ9CJCS9myxWyD4sewYYB3n8ZR9LiEpu3iNAExngi3xaGT4aKhACjbfTr76d1nK8fvPrbCGn6nJL7fLN6ApPg53WznkQ6jM1crZk5vv4MNac5YwfK6ra`

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