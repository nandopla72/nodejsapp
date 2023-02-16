job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/nandopla72/nodejsapp.git', 'master') { node ->
            node / gitConfigName('nandopla72')
            node / gitConfigEmail('nandopla@yahoo.es')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
	mailer('nandopla@yahoo.es', true, true)
    }
}
