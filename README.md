# DNAMirror
Java project to process gene sequences and emit sequence mirror images

What this project does: A file contains the DNA sequence of people. Find all the people who have same or mirror image of DNAs.

Input: “User1 ACGT” “User2 TGCA” “User3 ACG” “User4 ACGT” “User5 ACG” “User6 AGCT”

Output: User1, User2, User4
User3, User 5
User6

How to run it: Import the project in eclipse and create a JAR. Copy the jar file onto the local machine with Hadoop and use the hadoop streaming command similar to what's given below to execute it:

"$ hadoop jar <package_name.driver_class_name> <input file location on HDFS> <output location on HDFS>"

You can visit www.knowbigdata.com for more details and courses on Hadoop and Hadoop related technologies.
