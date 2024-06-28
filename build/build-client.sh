cp ../META-INF/MANIFEST-CLIENT.MF ../META-INF/MANIFEST.MF

javac ../com/Ben/SDR/Client/*.java

jar cmvf ../META-INF/MANIFEST.MF client.jar ../com/Ben/SDR/Client/*.class

rm ../com/Ben/SDR/Client/*.class
rm ../META-INF/MANIFEST.MF