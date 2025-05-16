# Android MVVM + Jetpack Compose

## Aplicación Android con arquitectura MVVM + Jetpack Compose (Login MVVM)

Continuando con el desarrollo de aplicaciones moviles, acabo de desarrollar una pequeña aplicación donde he volcado todo lo que he ido aprendiendo hasta la fecha sobre la arquitectura MVVM. Cada commit representa los avances sobre mi conocimiento en este inmenso mundo móvil.

Desglosando un poco, primero comienzo desarrollando la parte visible de la aplicación (los view). Jetpack compose no maneja automaticamente las modificaciones de los TextField como si sucedida con los 'EditText' en XML. por lo que hay 2 formas de manjear los datos, directamente en el propio view con variables locales, o bien, usando viewModel y LiveData, aunque más adelante usaré StateFlow ya que es mas moderno y se integra mejor con Jetpack compose. 

El último ha sido sin duda el más complicado hasta la fecha, ya que al fin he entendido como funciona Jetpack Compose (muy similar a React con el tema de reciclar componentes), la obsolescencia de LiveData y la integración de navigator con tipo seguro (la navegación entre views más moderna y estable que Jetpack compose ofrece). Debido a todo lo que se ha includo en este último commit y los cambios que se viene a futuro, he decidido continuar desde un nuevo proyecto, para así hacer las cosas bien desde el principio (es lo que tiene aprender continuamente, que siempre hay y habrá algo mal).