# Problem to Solve
Supposedly, Caesar (yes, that Caesar) used to “encrypt” (i.e., conceal in a reversible way) confidential messages by shifting each letter therein by some number of places. For instance, he might write A as B, B as C, C as D, …, and, wrapping around alphabetically, Z as A. And so, to say HELLO to someone, Caesar might write IFMMP instead. Upon receiving such messages from Caesar, recipients would have to “decrypt” them by shifting letters in the opposite direction by the same number of places.

The secrecy of this “cryptosystem” relied on only Caesar and the recipients knowing a secret, the number of places by which Caesar had shifted his letters (e.g., 1). Not particularly secure by modern standards, but, hey, if you’re perhaps the first in the world to do it, pretty secure!

Unencrypted text is generally called plaintext. Encrypted text is generally called ciphertext. And the secret used is called a key.

To be clear, then, here’s how encrypting HELLO with a key of 1 yields IFMMP:

<table>
  <tr>
    <td>plaintext</td>
    <td>H</td>
    <td>E</td>
    <td>L</td>
    <td>L</td>
    <td>O</td>
  </tr>
  <tr>
    <td>+ key</td>
    <td>1</td>
    <td>1</td>
    <td>1</td>
    <td>1</td>
    <td>1</td>
  </tr>
  <tr>
    <td> ciphertext</td>
    <td>I</td>
    <td>F</td>
    <td>M</td>
    <td>M</td>
    <td>P</td>
  </tr>
</table>

More formally, Caesar’s algorithm (i.e., cipher) encrypts messages by “rotating” each letter by $k$ positions. More formally, if $p$ is some plaintext (i.e., an unencrypted message), $p_{i}$ is the character $i^{th}$ in $p$, and $k$ is a secret key (i.e., a non-negative integer), then each letter $c_{i}$, in the ciphertext $c$, is computed as


$$c_{i} = (p_{i} + k)\mod 26$$


wherein$\mod 26$ here means “remainder when dividing by 26.” This formula perhaps makes the cipher seem more complicated than it is, but it’s really just a concise way of expressing the algorithm precisely. Indeed, for the sake of discussion, think of `A` (or `a`) as $0$, `B` (or `b`) as $1$, …, `H` (or `h`) as $7$, `I` (or `i`) as $8$, …, and `Z` (or `z`) as $25$. Suppose that Caesar just wants to say `Hi` to someone confidentially using, this time, a key, $k$, of 3. And so his plaintext, $p$, is `Hi`, in which case his plaintext’s first character, $p_{0}$, is `H` (aka 7), and his plaintext’s second character, $p_{1}$, is `i` (aka 8). His ciphertext’s first character,  $c_{0}$, is thus `K`, and his ciphertext’s second character, $c_{1}$, is thus `L`. Make sense?

Write a program that enables you to encrypt messages using Caesar’s cipher. At the time the user executes the program, they should decide, by providing a command-line argument, what the key should be in the secret message they’ll provide at runtime. We shouldn’t necessarily assume that the user’s key is going to be a number; though you may assume that, if it is a number, it will be a positive integer.
