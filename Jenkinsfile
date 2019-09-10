@Library('iib-library')_
import com.builder.GlobalVars
node {
    
    sh "rm -rf ${WORKSPACE}/*"

    String dir = "${GlobalVars.PROTECCIONSNAPSHOTS}api_empleadores_afiliados_desa/${PREFIX_VERSION}.${BUILD_ID}/"
    
    clonarFuentes url:   "https://vostpmde37.proteccion.com.co:10443/SERVICIOS_INTEGRACION/api_empleadores_afiliados.git",
                  branch: GlobalVars.BRANCH_DEVELOP
	
	implementarReferencias ()
	
	mqsipackagebar "-a APIEmpleadoresAfiliados.bar -w ./ -k APIEmpleadoresAfiliados -y APIEmpleadoresAfiliados_APL APIEmpleadoresAfiliados_CUSTOM"
					
    sh "mv *.bar BAR/"	
	
	ejecutarAnalisisEstatico "APIEmpleadoresAfiliados", "APIEmpleadoresAfiliados_APL", "APIEmpleadoresAfiliados_CUSTOM"
	
	almacenarBinarios '"pattern": "BAR/*", "target": "' + dir + 'BAR/"',
                      '"pattern": "MQ/*", "target": "' + dir + 'MQ/"'
     
    sh "cat BAR/ExecutionGroup.conf"
	
    urbanDeploy(
        baseDirectory: WORKSPACE,
	    filePattrn: "api_empleadores_afiliados_desa",
	    componentName: GlobalVars.COMPONENTNAME,
		app: GlobalVars.APP,
		enviroment: GlobalVars.ENVIROMENT_DEVELOP,
		processName: GlobalVars.PROCESSNAME,
		versionName: "${PREFIX_VERSION}.${BUILD_ID}",
		executionGroup: "BAR/*\nMQ/*")
    
}