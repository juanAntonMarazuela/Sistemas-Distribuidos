
//Contenido HTML inicial de la página con los criterios de búsqueda disponibles para las fotos
const htmlIndex = `
<div class="inner">
            <!-- Boxes -->
                <div class="thumbnails">

                    <div class="box">
                            <a class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por fecha mínima de captura</h3>
                                    <input type="checkbox" class="checks" name="type" value="fecha"><br>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por etiquetas asignadas</h3>
                                    <input type="checkbox" class="checks" name="type" value="etiqueta"><br>
                            </div>
                    </div>

                    <div class="box">
                            <a  class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por licencia que posee la imagen</h3>
                                    <input type="checkbox" class="checks" name="type" value="licencia"><br>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por tamaño de la imagen</h3>
                                    <input type="checkbox" class="checks" name="type" value="tamaño"><br>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por geolocalización</h3>
                                    <input type="checkbox" class="checks" name="type" value="geolocalizacion"><br>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por texto asociado a una imagen</h3>
                                    <input type="checkbox" class="checks" name="type" value="texto"><br>
                            </div>
                    </div>
                    <input type="submit" class="busquedaBtn" value="Siguiente" id="enviar">
                </div>
        </div>
`;

//Contenido HTML para especificar el criterio de búsqueda por etiqueta
const tagsForm = `
                <h2 class="tituloBusq">Fotos por un tag especifico</h2>
                <div class="formu">
                    <h3>Introduce el tag para las fotos que quieres buscar:</h3>
                    <input type="text" value="Prueba"  class="inputData" search = 'tags=' name="Etiqueta">
                    <br>
                </div>
                <br><br>
`;

//Contenido HTML para especificar el criterio de búsqueda por texto
const TextForm = `
                <h2 class="tituloBusq">Fotos por texto asociado a una imagen</h2>
                <div class="formu">
                    <h3>Introduce el texto asociado a una imagen (titulo,etiquetas,...), de la foto que deseas buscar:</h3>
                    <input type="text" value="altotajo"  class="inputData" search = 'text=' name="Texto">
                    <br>
                </div>
                <br><br>
`;

//Contenido HTML para especificar el criterio de búsqueda por fecha de captura mínima
const MinDateForm = `
                <h2 class="tituloBusq">Fotos a partir de una fecha</h2>
                <div class="formu">
                    <h3>Selecciona la fecha a partir de la que quieres buscar:</h3>
                    <input class ="calendar inputData" type="date" search='min_taken_date=' name="Fecha minima">
                    <br><br>
                </div>
                <br><br>
`;

//Contenido HTML para especificar el criterio de búsqueda por licencia de las fotos
const LicenseForm = `
                <h2 class="tituloBusq">Fotos a partir de una licencia</h2>
                <div class="formu">
                    <h3>Selecciona la licencia de las fotos que quieres buscar:</h3>
                    <select class="inputData" search='license=' name="Licencia">
                        <option value="0">Todos los derechos reservados</option>
                        <option value="10">Obra de dominio público</option>
                        <option value="9">Dedicatoria al dominio público</option>
                        <option value="4">Atribución</option>
                        <option value="5">Atribución-CompartirIgual</option>
                        <option value="6">Atribución-SinDerivadas</option>
                        <option value="2">Atribución-NoComercial</option>
                        <option value="1">Atribución-NoComercial-CompartirIgual</option>
                        <option value="3">Atribución-NoComercial-SinDerivadas</option>
                    </select>
                    <br>
                </div>
                <br><br>
            
`;

//Contenido HTML para especificar el criterio de búsqueda por posibilidad de geolocalización
const GeoForm = `
                <h2 class="tituloBusq">Fotos a partir de geolocalización</h2>
                <div class="formu">
                    <h3>Selecciona si deseas que aparezcan las fotos con o sin localización:</h3>
                    <select  class="inputData" search='hasgeo=' name="Tiene localizacion">
                        <option value="0">Mostrar fotos sin localización</option>
                        <option value="1">Mostrar fotos con localización</option>
                    </select>
                    <br>
                </div>
                <br><br>
            
`;

//Contenido HTML para especificar el criterio de búsqueda por tamaño de las fotos
const sizeForm = `
                <h2 class="tituloBusq">Fotos por un tamaño mínimo/máximo</h2>
                <div class="formu">
                    <h3>Elige el tamaño de las imagenes a buscar</h3>
                    <select class="inputData" search="dimension_search_mode=" name="Tamaño minimo">
                        <option value="">Mostrar todas</option>
                        <option value="min&width=640&height=640">Medianas (640x640)</option>
                        <option value="min&width=1024&height=1024">Grandes (1024x1024)</option>
                    </select>
                </div>
                <br><br>
`;

//Contenido HTML adicional la página de busqueda por criterio, con la posibilidad de cambiar los parametros
//de busqueda o volver al inicio de la página web
const restPageHtml = `
        <div id="imagenes">
            
        </div>
        <a class ="link" id ="buscarPorOtraEtiqueta">Cambiar parametros de busqueda</a>
        <br><br>
        <a class ="link" id ="botonIndex" >Volver a Inicio</a>
    </div>
`;

//Contenido HTML resultante de la búsqueda por criterio de las fotos, siendo el div "imágenes"
//el lugar donde se añadirán las fotos desde Flickr posteriormente
const busquedaCriterioHtml = `
<div class="inner inicio">
                <h2>Fotos públicas del usuario</h2>
                <div id="imagenes">
                    
                </div>
            </div>
`;

//Contenido HTML para visualizar a mayor tamaño una foto específica de las resultantes de un criterio de búsqueda
const imagenConcretaHtml = `
<div class="inner">
                <h2>Fotos a partir de una fecha</h2>
                <img id ="imageReceptor">
                    
                
                <br><br>
                <a class ="link" id ="botonIndex" >Volver a Inicio</a>
    </div>
`;

//Función que se ejecuta al cargar la página
$(changeContent("index"));

//Función que cambia el contenido de la página según itere el usuario por la web
//(página principal, de los criterios de busqueda y de una imagen concreta)
function changeContent(page, aditionalInfo) {

    switch (page) {
        case "index":
            {
                generateIndexPage();
                break;
            };

        case "busqueda":
            {
                generateBusquedaCriterio(aditionalInfo);
                break;
            }

        case "imagenConcreta":
            {
                generateImagenConcreta(aditionalInfo);
                break;
            }

    }

}

//Función que genera la página inicial de la web, añadiendole el contenido inicial antes creado en htmlIndex
//y cambiando su contenido en caso de que el usuario haga click en un criterio de busqueda
function generateIndexPage() {
    $('#main').append().html(htmlIndex);

    /* Events*/
    $('.busquedaBtn').click(function () {
        let checked = [];
        $('input:checked').each(function() {
            checked.push($(this).attr("value"));
        });
        console.log(checked);
        if (checked.length > 0) {
        changeContent("busqueda",checked);
        } else {
            alert("No ha elegido ningún criterio de búsqueda");
        }
    });
}

//Función que genera la página de una busqueda de criterio, añadiendole el contenido HTML según el criterio
//seleccionado, preparando la búsqueda en la API de flickr introduciendo el criterio seleccionado en la 
//variable "search" y creando eventos para cambiar los parametros de busqueda o volver al inicio de la web
var textoBusqueda=""; /* El texto con los parametros de la busqueda que se mostrara al lado de cada foto en los resultados */
function generateBusquedaCriterio(criterio) {
    let form = `<div class="inner inicio"> `;
    for (let n in criterio){ 
        switch (criterio[n]) {
            case "etiqueta":
                {
                    form += tagsForm;
                    break;
                }
            case "fecha":
                {
                    form += MinDateForm;
                    break;
                }
            case "licencia":
                {
                    form += LicenseForm;
                    break;
                }
            case "tamaño":
                {
                    form += sizeForm;
                    break;
                }
            case "geolocalizacion":
                {
                    form += GeoForm;
                    break;
                }
            case "texto":
                {
                    form += TextForm;
                    break;
                }
            }
    }


    form += 
    ` <span id="enviarSpan" >
        <h3>Pulsa el boton para buscar</h3>
        <input type="submit" value="Enviar" id="enviar">
    </span>
    `;

    $('#main').append().html(form + restPageHtml);

    $("#enviar").click(function () {
        let search = "";
        textoBusqueda = "";
        $("#enviarSpan").hide("slow");
        /* Se recogen los datos de la busqueda de los inputs que pertenecen la clase .inputData */
        $(".inputData").each(function() {
            search += '&';
            search += $(this).attr("search") + $(this).val();
            textoBusqueda +=  $(this).attr("name") + ": " + $(this).val() + " ; ";

        });

        console.log(search);

        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=' +
            api_key + '&user_id=' + user_id + search +
            '&format=json&nojsoncallback=1',
            mostrar_fotos
        );
    });


    $('#buscarPorOtraEtiqueta').click(function () {
        generateBusquedaCriterio(criterio);
    })

    $('#botonIndex').click(function () {
        changeContent("index");
    })

}

//Función que genera la página de una imagen especifica, seleccionada previamente de las resultantes de una 
//búsqueda, además crea el evento para volver a la página inicial haciendo click en un botón
function generateImagenConcreta(url) {

    $('#main').append().html(imagenConcretaHtml);

    $('#imageReceptor').attr("src", url + '_b.jpg')

    $('#botonIndex').click(function () {
        changeContent("index");
    })
}

//Función que realiza la petición a la API de flickr, devolviendo las imagenes resultantes de los criterios
//de busqueda elegidos y añadiendolos a la página dentro del div "imágenes"
function mostrar_fotos(info) {
    var i;
    let urls = [];
    if (info.photos.photo.length == 0) {
        $("#imagenes").append().html(`<h3> No hay fotos que coincidan con los parametros de busqueda </h3>`);
    } else {
        $("#imagenes").append("<div>").addClass("thumbnails");
        for (i = 0; i < info.photos.photo.length; i++) {
            var item = info.photos.photo[i];
            var url = 'https://farm' + item.farm + ".staticflickr.com/" + item.server +
                '/' + item.id + '_' + item.secret;
            urls.push(url);
            $("#imagenes").append($("<img/>").attr({
                "src": url + '_m.jpg',
                "id": i
            }).click(function () {
                let j = $(this).attr('id');
                changeContent("imagenConcreta", urls[j]);
            }).addClass("link"));
            $("#imagenes").append($("<p> Busqueda = " + "<b>" + textoBusqueda + "</b>" + "</p>"));

        }
    }
    $("#imagenes").append("</div>");
    $('div.formu').slideUp(1000);
}
