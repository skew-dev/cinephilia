# DevOps RoadMap

Conjunto de prácticas que agrupan el desarrollo de software ( Dev ) y las operaciones de TI ( Ops ). Su objetivo es hacer más rápido el ciclo de vida del desarrollo de software y proporcionar una entrega continua de alta calidad. DevOps es una práctica complementaria al desarrollo de software ágil ; esto debido a que varias de las características de DevOps provienen de la metodología Agile (término en inglés para la metodologÍa de desarrollo ágil).
>[DevOps](https://es.wikipedia.org/wiki/DevOps)

>[¿Qué es la cultura DevOps](https://www.facebook.com/workshoptech/videos/1483435148698047)

## CI (Integración Continua)

Práctica de desarrollo en la cual los desarrolladores integran su código a un repositorio central, esto de forma periódica, varias veces por día. Cada vez que un miembro del equipo realiza un commit sobre el control de versiones (Git & GitHub por ejemplo), el proyecto se compila y se ejecutan todas sus pruebas unitarias, todo esto de forma automática.

>[Integración continua](https://codigofacilito.com/articulos/integracion-continua)


## CD (Distribución Continua e Implementación Continua)

Después de la automatización de los diseños y las pruebas de unidad e integración de la CI, la distribución continua automatiza la liberación de ese código validado hacia un repositorio. Por eso, para que el proceso de distribución continua sea eficaz, es importante que la CI ya esté incorporada a su canal de desarrollo. El objetivo de la distribución continua es tener una base de código que pueda implementarse en un entorno de producción en cualquier momento.

La implementación continua hace referencia a la liberación automática de los cambios que implementa el desarrollador desde el repositorio hasta la producción, para que los clientes puedan usarlos.

### Herramientas

#### [Travis CI](https://travis-ci.org/)

Travis CI es un servicio de integración continua alojado que se utiliza para crear y probar proyectos de software alojados en GitHub y Bitbucket.

Características importantes:
- Integración con [GitHub](https://github.com).
- Integración con [Heroku](https://heroku.com).
- FLows:
  + Branch Build: Push to Github -> GH triggers Travis CI to build -> Travis checks build -> Travis deploys to Heroku -> Travis tells your team all is well.
  + Pull Request Build: Pull Request on GitHub -> Travis CI is notified the build is mergeable -> Travis updates de build passes -> Merge in the PR goodness.

>[Travis CI](https://en.wikipedia.org/wiki/Travis_CI)
#### [GitHub Actions](https://github.com/features/actions)

Automatiza, personaliza y ejecuta tus flujos de trabajo de desarrollo de software directamente en tu repositorio con GitHub Actions. Puedes descubrir, crear y compartir acciones para realizar cualquier trabajo que quieras, incluído CI/CD.

Características importantes
- Integración con [cientos de aplicaciones](https://github.com/marketplace?category=&query=&type=actions&verification=). 
- Permite crear casi cualquier tipo de github flow, además se adhiere fácilmente a los PR por naturaleza de la plataforma.

>[GitHub Actions](https://docs.github.com/es/actions)


#### [Jenkins](https://www.jenkins.io/)

Servidor de automatización de código abierto, integrable con cientos de plugins para testing, building y deployment.

Características importantes
- Integración con [cientos de plugins](https://plugins.jenkins.io/). 
- Permite trigger con GitHub webhooks.
- Manejo y exportación de artifacts.
- 100% Gratuito si se aloja localmente.



