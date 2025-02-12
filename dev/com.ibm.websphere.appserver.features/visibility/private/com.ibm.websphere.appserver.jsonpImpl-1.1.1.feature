# This private impl feature corresponds to JSON-P 1.1 with the Glassfish implementation
-include= ~${workspace}/cnf/resources/bnd/feature.props
symbolicName=com.ibm.websphere.appserver.jsonpImpl-1.1.1
WLP-DisableAllFeatures-OnConflict: false
singleton=true
visibility=private
-features=com.ibm.websphere.appserver.eeCompatible-8.0
-bundles=com.ibm.websphere.javaee.jsonp.1.1; location:="dev/api/spec/,lib/"; mavenCoordinates="javax.json:javax.json-api:1.1.4", \
 com.ibm.ws.org.glassfish.json.1.1
kind=ga
edition=core
WLP-Activation-Type: parallel
