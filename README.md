Rework of https://github.com/nkunkee/demo_java_jersey --> https://github.com/kfrankli/demo_java_jersey --> https://github.com/jeckste/java-demo --> https://github.com/kfrankli/java-demo.git for uber jar on OCP






>git clone https://github.com/kfrankli/java-demo.git
>
>cd java-demo
>
>PROJECT_NAME="demo-project"
>
>APP_NAME="wustl-app"
>
>oc new-project $PROJECT_NAME-cicd
>
>oc process -f .openshift/cicd.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME | oc create -f - -n $PROJECT_NAME-cicd
>
>oc new-project $PROJECT_NAME-dev
>
>oc process -f .openshift/dev.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME-dev CICD_PROJECT_NAME=$PROJECT_NAME-cicd | oc create -f - -n $PROJECT_NAME-dev
>
>oc new-project  $PROJECT_NAME-prod
>
>oc process -f .openshift/prod.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME-prod CICD_PROJECT_NAME=$PROJECT_NAME-cicd IMAGE_STREAM_NAMESPACE=$PROJECT_NAME-prod | oc create -f - -n $PROJECT_NAME-prod


Cleanup

>oc delete project $PROJECT_NAME-cicd $PROJECT_NAME-dev $PROJECT_NAME-prod
