# Options

SigmaFi offers option contracts to allow users to buy and sell call and put options between any assets on the Ergo blockchain.
SigmaFi options have few or no restrictions on expiry dates, strike prices, or underlying assets used.
There are two ways for a user to buy an option:
- Close an open option order to receive an option NFT
- Buy an option NFT from an exchange contract

In contrast, there exists only one way for a user to sell an option contract. Selling option contracts requires
creating an open option order, which must then be closed by a buyer.

It is suggested that UI's created for SigmaFi options make this distinction indistinguishable for users (which will help liquidity
in such a p2p marketplace) by default. To aid in this matter, finding option information for a given option token
is as simple as searching for the spent box whose id is equal to the option token's id.

## Design
The general design of
SigmaFi's option contracts is to reduce options down to their most basic form. Options are simply agreements
which give the *buyer* the right but not the obligation to swap a set amount of assets at a given exchange rate before some expiry date.
The definition of *Calls* and *Puts* is in reality determined by which assets are exchanged, meaning that the distinction between
these two option types is blurred. SigmaFi's option contracts follow this philosophy, so in the end it is the UI or the option buyer
which decides whether a given option is a *Call* or *Put*.

