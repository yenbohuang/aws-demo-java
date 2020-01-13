# Summary

This project is for AWS tools testing by free-tier services. Create a free-tier account on <https://console.aws.amazon.com>.

# Prepare "awsdemo.properties" file

"awsdemo.properties" contains my account information; create your own file and make some code changes.

    iot.thingName=
    iot.thingArn=
    iot.certificateArn=
    iot.certificateId=
    iot.certificateFilePath=
    iot.privateKeyFilePath=
    iot.policy.PubSubToAnyTopic.name=
    iot.policy.PubSubToAnyTopic.arn=
    iot.endpointAddress=

# AWS IoT private key

A private key should be look like this:

    -----BEGIN RSA PRIVATE KEY-----
    ...
    -----END RSA PRIVATE KEY-----


PEM file cannot be read by PKCS8EncodedKeySpec class. You need to convert it by the following command:

    openssl pkcs8 -topk8 -inform PEM -outform DER -in privateKey.pem  -nocrypt > pkcs8_key

See details on <http://stackoverflow.com/questions/3243018/how-to-load-rsa-private-key-from-file>

Or, you can use the following readers:

* PEM <http://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/auth/PEM.html>
* Bouncy Castle <https://www.bouncycastle.org/>

# AWS references

* General references <http://docs.aws.amazon.com/general/latest/gr/Welcome.html>
* AWS SDK for Java <https://aws.amazon.com/sdk-for-java/>
* AWS IoT <https://aws.amazon.com/iot/>
* AWS IoT developer guide <http://docs.aws.amazon.com/iot/latest/developerguide/>
