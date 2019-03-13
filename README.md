Rework of https://github.com/nkunkee/demo_java_jersey --> https://github.com/kfrankli/demo_java_jersey --> https://github.com/jeckste/java-demo --> https://github.com/kfrankli/java-demo.git for uber jar on OCP





	
>git clone https://github.com/kfrankli/java-demo.git
>
>cd java-demo
>
>PROJECT_NAME="demonstration-project"
>	
>oc new-project $PROJECT_NAME
>	
>oc process -f .openshift/openjdk18-s2i.yaml | oc create -f - -n $PROJECT_NAME
