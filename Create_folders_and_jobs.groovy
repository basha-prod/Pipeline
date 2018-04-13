/* Creates folders & jobs under created folder */
['01_Builds','02_Fast_Track','03_Slow_Track','04_Stability_Track','05_Release_Track','06_Soak_Track'].each { 
    folder("$it") {
    }
    freeStyleJob("01_Builds/ee_jenkins") {
        description("ee_jenkins generated by seed job")
        label("")
        logRotator {
            numToKeep 15
        }
        scm {
            git {
                remote {
                    github('cmangamm/Pipeline','https')
                }
                branch('master')
            }
        }
        steps {
            shell('echo "Hello,This is step section"')
        }
    }
}`