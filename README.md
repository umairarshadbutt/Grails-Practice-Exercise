Grails Practice Exercise
==============================

Grails manages static resources (such as javascript and css files) with the resources plugin.  The resources plugin manages static resources via modules, like the Jquery Module, that define via a config file which static resources a module requires. For a more details explanation see the [Grails docs](http://grails.org/doc/latest/guide/theWebLayer.html#resources) on using Static Resource. 

The [Grails Modules Manager plugin](https://github.com/groovydev/modules-manager-grails-plugin) allows dependencies on web libraries to be declared in the Grails build configuration, BuildConfig.groovy.  It resolves theses dependencies and creates modules that can be used by the resources plugin.  It does this by downloading the jar files from webjars.org and extracting the web libraries from the jar files.  It then creates grails specific resource modules from these web libraries. 

Steps for using the plugin:
=============================================

1 - Clone the modules manager plugin from:
https://github.com/groovydev/modules-manager-grails-plugin.git

2 - Build the plugin:
	
	grails package-plugin

3 - Install the plugin into your grails project from the file system - this assumes the plugin is in the same parent directory as the project:
	
	grails install-plugin ../modules-manager-grails-plugin/grails-modules-manager-0.2.1.zip

4 - Define the javascript and css dependencies.  In grails-app/config/BuildConfig.groovy add:

	dependencies {
    	compile 'org.webjars:bootstrap:2.1.1'
	}

5 - Run the refresh modules command which will download the necessary javascript and css dependencies:

	grails refresh-modules

6 - Notice how the plugin added the file conf/ModulesBootstrapResources.groovy.  This module config file is used by the resources plugin to define the module dependencies and static resources.

7 - Add the module dependencies to the web page - see the example in [views/index.gsp](https://github.com/webjars/sample-grails/blob/master/grails-app/views/index.gsp). This is done by adding the require tag to the html page to include the static resource modules. Also note that it is necessary to add the layoutResources tag twice to the page. 

In the head tag add:

	<head>
	    <r:require modules="jquery, bootstrap"/>
	    <r:layoutResources/>

And then at the bottom of the page add:

	<r:layoutResources/>
	</body>


8 - The resource manager then optimizes when the javascript is load by when it is need in the page and by default includes the javascript at the bottom of the page. For this reason it is necessary to put the javascript in a <r:script> tag so that the necessary dependencies will be included when the layoutResources tag is called. For example to use a jquery initialization function add the following to the page::

 	<r:script>
        $(function () { ... }
