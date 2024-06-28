cp ../META-INF/MANIFEST-SERVER.MF ../META-INF/MANIFEST.MF

javac ../com/Ben/SDR/Server/*.java ../com/Ben/SDR/Tools/*.java

jar cmvf ../META-INF/MANIFEST.MF server.jar ../com/Ben/SDR/Server/*.class ../com/Ben/SDR/Server/*.class

rm ../com/Ben/SDR/Server/*.class
rm ../META-INF/MANIFEST.MF