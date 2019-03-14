Rework of https://github.com/nkunkee/demo_java_jersey --> https://github.com/kfrankli/demo_java_jersey --> https://github.com/jeckste/java-demo --> https://github.com/kfrankli/java-demo.git for uber jar on OCP



# Setup/Install Instructions

This will create 3 projects. The cicd project will contain the Jenkins server which will run a basic pipeline defined inline in `./.openshift/cicd.yaml` that will use a OpenShift S2I build to build the Java Fat Jar application under `./java-app` in a Red Hat OpenJDK 1.8 image in the **dev** environment. It will then ask for user input to promote to the **prod** environment and if the user chooses to proceed, it will tag the image from the **dev** environment to the **prod** environment and deploy to **prod**

```
git clone https://github.com/kfrankli/java-demo.git

cd java-demo

PROJECT_NAME="demo-project"

APP_NAME="wustl-app"

# Make the needed projects $PROJECT_NAME-cicd, $PROJECT_NAME-dev, and $PROJECT_NAME-prod. This may require elevated privileges

oc new-project $PROJECT_NAME-cicd

oc new-project $PROJECT_NAME-dev

oc new-project  $PROJECT_NAME-prod

# This will process the template files. 

oc process -f .openshift/cicd.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME | oc create -f - -n $PROJECT_NAME-cicd

oc process -f .openshift/dev.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME-dev CICD_PROJECT_NAME=$PROJECT_NAME-cicd | 

oc process -f .openshift/prod.yaml -p APP_NAME=$APP_NAME PROJECT_NAME=$PROJECT_NAME-prod CICD_PROJECT_NAME=$PROJECT_NAME-cicd IMAGE_STREAM_NAMESPACE=$PROJECT_NAME-prod | oc create -f - -n $PROJECT_NAME-prod
```

# Cleanup

Use this to clean up the projects and delete everything. This will likely require elevated privlages.

```
oc delete project $PROJECT_NAME-cicd $PROJECT_NAME-dev $PROJECT_NAME-prod
```
