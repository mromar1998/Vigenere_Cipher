the submitted project folder contains 4 main components:

1-the class file in which all the code is written located in src document named "Vigenere.java"

2-a file in the main directory named "text.txt", this file contains the key and the text that you want to encrypt "you can change the contents of the file to any key/text combinations you want"

3-a file in the main directory named "encrypted.dec" this file will contain the encrypted text after running the program.

4-a file in the main directory name "decrypted.txt" that contain the decrypted text after running the program.

instructions to run the program:

----------------------------------

encrypt method():
1- first of all open the text.txt file file write the key and the text that you want 
2- run the program after its done running open the file encrypted.dec and check the result

----------------------------------
decrypt method():
this method by default will take the file encrypted.dec which is the encrypt method result.

but if you want do decrypt a certain file with a certain key

1- first of all go to the code line 46 and look for the function decrypt call and a file object

2- change the file object by changing the name or provide the path to the file you want to decrypt

3- then change the tempKey in the method call to the key used to encrypt the file you want to decrypt 

4- then check the result of this call in the file decrypted.txt in the main directory

exmaple:

File enc=new File("my\\specific\\file.txt")
decryption(enc,"my Specific Key");

dfeault:

File enc = new File("encrypted.dec");
        decryption(enc,tempKey);
-------------------------------------

there are sample values in all file for checking 
