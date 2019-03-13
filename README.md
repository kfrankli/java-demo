rework of https://github.com/kfrankli/demo_java_jersey for uber jar

git clone https://github.com/kfrankli/java-demo.git
cd java-demo
PROJECT_NAME="demonstration-project"
oc new-project $PROJECT_NAME
oc process -f .openshift/openjdk18-s2i.yaml | oc create -f - -n $PROJECT_NAME
