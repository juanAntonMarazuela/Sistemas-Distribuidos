const htmlIndex = `
<div class="inner">
                
            <!-- Boxes -->
                <div class="thumbnails">

                    <div class="box">
                            <a class="image fit"><img src="images/fecha.jpe" alt="" class="fotosIndex" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por fecha mínima de captura</h3>
                                    <a class="button fit busquedaBtn" value ="fechaMinima" >Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"><img src="images/tag.jpg" alt="" class="fotosIndex"/></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por etiquetas asignadas</h3>
                                    <a  class="button style2 busquedaBtn" value="tag">Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a  class="image fit"><img src="images/licencia.png" alt="" class="fotosIndex"/></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por licencia que posee la imagen</h3>
                                    <a class="button style3 fit busquedaBtn" value ="license" >Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"><img src="images/fotoTamaño.jpe" alt="" class="fotosIndex"/></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por tamaño de la imagen</h3>
                                    <a class="button style4 fit busquedaBtn" value ="size" >Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"><img src="images/fotoGeo.jpg" alt="" class="fotosIndex"/></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda por geolocalización</h3>
                                    <a class="button style3 fit busquedaBtn"  value="geo">Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a class="image fit"><img src="images/pic06.jpg" alt="" class="fotosIndex"/></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #6</h3>
                                    <a class="button fit"  >Buscar</a>
                            </div>
                    </div>
                    
                </div>
            </div>
`;

const tagsForm = `
<div class="inner">
                <h2 class="tituloBusq">Fotos por un tag especifico</h2>
                <div class="formu">
                    <h3>Introduce el tag para las fotos que quieres buscar:</h3>
                    <input type="text" value="Prueba" id="inputData">
                    <br>
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
`;

const MinDateForm = `
<div class="inner">
                <h2 class="tituloBusq">Fotos a partir de una fecha</h2>
                <div class="formu">
                    <h3>Selecciona la fecha a partir de la que quieres buscar:</h3>
                    <input class ="calendar" type="date" id="inputData">
                    <br><br>
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
`;

const LicenseForm = `
            <div class="inner">
                <h2 class="tituloBusq">Fotos a partir de una licencia</h2>
                <div class="formu">
                    <h3>Selecciona la licencia de las fotos que quieres buscar:</h3>
                    <select id="inputData">
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
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
            
`;

const GeoForm = `
            <div class="inner">
                <h2 class="tituloBusq">Fotos a partir de geolocalización</h2>
                <div class="formu">
                    <h3>Selecciona si deseas que aparezcan las fotos con o sin localización:</h3>
                    <select id="inputData">
                        <option value="0">Mostrar fotos sin localización</option>
                        <option value="1">Mostrar fotos con localización</option>
                    </select>
                    <br>
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
            
`;

const restPageHtml = `
        <div id="imagenes">
            
        </div>
        <a class ="link" id ="buscarPorOtraEtiqueta">Cambiar parametros de busqueda</a>
        <br>
        <a class ="link" id ="botonIndex" >Volver a Inicio</a>
    </div>
`;

const sizeForm = `
<div class="inner">
                <h2 class="tituloBusq">Fotos por un tamaño mínimo/máximo</h2>
                <div class="formu">
                    <h3>Elige si la imagen tendrá como mínimo o como máximo las siguientes dimensiones:</h3>
                    <select id="inputData">
                        <option value="min">Como mínimo</option>
                        <option value="max">Como máximo</option>
                    </select>
                    <br>
                    <h3>Introduce el valor de la anchura:</h3>
                    <input type="number" value="0" id="widthInput">
                    <br>
                    <h3>Introduce el valor de la altura:</h3>
                    <input type="number" value="0" id="heightInput">
                    <br>
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
`;

const busquedaCriterioHtml = `
<div class="inner inicio">
                <h2>Fotos públicas del usuario</h2>
                <div id="imagenes">
                    
                </div>
            </div>
`;

const imagenConcretaHtml = `
<div class="inner">
                <h2>Fotos a partir de una fecha</h2>
                <img id ="imageReceptor">
                    
                
                <br><br>
                <a class ="link" id ="botonIndex" >Volver a Inicio</a>
    </div>
`;

/* Funcion que se ejecuta al cargar la pagina*/
$(changeContent("index"));

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


function generateIndexPage() {
    $('#main').append().html(htmlIndex);

    /* Events */
    $('.busquedaBtn').each(function () {
        console.log("Iterated");
        $(this).click(function () {
            changeContent("busqueda", $(this).attr('value'));
        });
    });
}

function generateBusquedaCriterio(criterio) {
    let form;
    let search;
    switch (criterio) {
        case "tag":
            {
                form = tagsForm;
                search = 'tags='
                break;
            }
        case "fechaMinima":
            {
                form = MinDateForm;
                search = 'min_taken_date='
                break;
            }
        case "license":
            {
                form = LicenseForm;
                search = 'license='
                break;
            }
        case "size":
            {
                form = sizeForm;
                search = 'width=' + $('#widthInput').val() + "&height=" + $('#heightInput').val() + "&dimension_search_mode=";
                break;
            }
        case "geo":
            {
                form = GeoForm;
                search = 'hasgeo='
                break;
            }
    }

    $('#main').append().html(form + restPageHtml);

    $("#enviar").click(function () {
        searchData = document.getElementById('inputData').value;
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=' +
            api_key + '&user_id=' + user_id + '&' + search + searchData +
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

function generateImagenConcreta(url) {

    $('#main').append().html(imagenConcretaHtml);

    $('#imageReceptor').attr("src", url + '_b.jpg')

    $('#botonIndex').click(function () {
        changeContent("index");
    })
}

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
            $("#imagenes").append($("<p> Busqueda = " + "<b>" +$('#inputData').val() + "</b>" + "</p>"));
            
        }
    }
    $("#imagenes").append("</div>");
    $('div.formu').slideUp(1000);
}
