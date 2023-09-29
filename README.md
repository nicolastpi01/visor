# visor

Este es el proyecto ppal del visor, es un Servlet que cuenta con los metodos para obtener las anotaciones y guardarlas (utiliza otros endPoints para llevar a cabo esta tarea). A la vez cuenta con otro Servlet para EntryServlet.java el cual esta expuesto de modo de recibir datos sobre el cliente que quiere visualizar el documento.

En el archivo ViewerServlet, las constantes #urlFromViewerSaveMarcks y #urlFromViewerGetMarcks indican los servicios para guardar y obtener las anotaciones respectivamente. Reemplazar estos por los propios para simular estas funcionalidades. Por ejemplo, si trabajasemos local:

* urlFromViewerSaveMarcks = "http://localhost:8081/save";
* urlFromViewerGetMarcks = "http://localhost:8081/example";

En el archivo LPAServiceConfigurator reemplazar la direccion que se le pasa al new File() por la que desees. Este es el lugar donde se van a ir guardando las imagenes que se obtienen desde el servicio de XContent en el Server.

Hay que instalar el visor de Daeja 5.0.7 es el que se usa en este proyecto. Seguir cualquiera de los metodos de instalacion recomendados en el siguiente link: https://www.ibm.com/docs/en/daeja-viewone/5.0.7?topic=viewone-installing-daeja-viewer-modules


Requerimientos:

* Java 8
* (Variables del sistema, indicar la jdk) : JAVA_HOME = C:\Program Files\Java\jdk-1.8\
