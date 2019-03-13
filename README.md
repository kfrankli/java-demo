rework of https://github.com/kfrankli/demo_java_jersey for uber jar

oc import-image my-redhat-openjdk-18/openjdk18-openshift --from=registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift --confirm
oc new-build --binary=true --name=jdk-us-app --image-stream=openjdk18-openshift
mvn clean install
cp target/demo_java_jersey-1.0-SNAPSHOT-jar-with-dependencies.jar ocp/deployments/
oc start-build jdk-us-app --from-dir=./ocp --follow
oc new-app jdk-us-app
oc expose svc/jdk-us-app

