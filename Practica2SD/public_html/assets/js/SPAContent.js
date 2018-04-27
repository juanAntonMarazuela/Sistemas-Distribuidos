const htmlIndex = `
<div class="inner">
                
            <!-- Boxes -->
                <div class="thumbnails">

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/fecha.jpe" alt="" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #1</h3>
                                    <p>Búsqueda por fecha mínima de captura</p>
                                    <a class="button fit busquedaBtn" value ="fechaMinima" >Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/tag.jpg" alt="" /></a>
                            <div class="inner">
                                    <h3>Busqueda por Tags</h3>
                                    <p>Búsqueda por posibilidad de etiquetas</p>
                                    <a id ="busquedaTags" class="button style2">Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/pic03.jpg" alt="" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #3</h3>
                                    <p>Explicación de la opción de búsqueda #3</p>
                                    <a class="button style3 fit busquedaBtn" value ="Busqueda3" >Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/pic04.jpg" alt="" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #4</h3>
                                    <p>Explicación de la opción de búsqueda #4</p>
                                    <a href="https://youtu.be/s6zR2T9vn2c" class="button style2 fit" data-poptrox="youtube,800x400">Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/pic05.jpg" alt="" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #5</h3>
                                    <p>Explicación de la opción de búsqueda #5</p>
                                    <a href="https://youtu.be/s6zR2T9vn2c" class="button style3 fit" data-poptrox="youtube,800x400">Buscar</a>
                            </div>
                    </div>

                    <div class="box">
                            <a href="https://youtu.be/s6zR2T9vn2c" class="image fit"><img src="images/pic06.jpg" alt="" /></a>
                            <div class="inner">
                                    <h3>Opción de búsqueda #6</h3>
                                    <p>Explicación de la opción de búsqueda #6</p>
                                    <a href="https://youtu.be/s6zR2T9vn2c" class="button fit" data-poptrox="youtube,800x400">Buscar</a>
                            </div>
                    </div>
                    
                </div>
            </div>
`;

const buscarPorTagsHtml = `
<div class="inner">
                <h2>Fotos por un tag especifico</h2>
                <div class="formu">
                    <h3>Introduce el tag para las fotos que quieres buscar:</h3>
                    <input type="text" value="Prueba" id="tag">
                    <br>
                    <h3>Pulsa el boton para buscar</h3>
                    <input type="submit" value="Enviar" id="enviar">
                </div>
                <br><br>
                <h3>Fotos</h3>
                <div id="imagenes">
                    
                </div>
                <a href="tags.html">Buscar por otra etiqueta</a>
                <br>
                <a id ="botonIndex" >Volver a Inicio</a>
            </div>
`;

const busquedaCriterioHtml = `
<div class="inner inicio">
                <h2>Fotos públicas del usuario</h2>
                <div id="imagenes">
                    
                </div>
            </div>
`; 

/* Funcion que se ejecuta al cargar la pagina*/
$(changeContent("index"));

function changeContent(page, aditionalInfo) {

    switch (page){
        case "index" : {
            generateIndexPage();
            break;
        };
        case  "buscarPorTags" : {
            generateBusquedaTagsPage();
            break;
        };

        case "busqueda" : {
            generateBusquedaCriterio (aditionalInfo);
            break;
        }

        case "imagenConcreta" : {
            generateImagenConcreta (aditionalInfo);
            break; 
        }

    }

}


function generateIndexPage () {
    $('#main').append().html(htmlIndex);

    /* Events */
    $('.busquedaBtn').each(function () {
        console.log("Iterated");
        $(this).click(function () {
            console.log("clicked");
            busqueda($(this).attr('value'));
        });
    });


    /* La busqueda por tags va aparte */
    $('#busquedaTags').click(function () {
        changeContent("buscarPorTags");
    });


}

function generateBusquedaTagsPage() {
    $('#main').append().html(buscarPorTagsHtml);


    /* Events */

    var tag;

    
    $("#enviar").click(function(){
        tag = document.getElementById('tag').value;
        $.getJSON('https://api.flickr.com/services/rest/?&method=flickr.photos.search&api_key=' 
             + api_key + '&user_id=' +user_id + '&tags=' + tag +
            '&format=json&nojsoncallback=1',
            mostrar_fotos
        );
    });	

    $('#botonIndex').click(function () {
        changeContent("index");
    })    
}


function busqueda(value) {
   console.log(value);
}

function mostrar_fotos(info){
    var i;
    for (i=0;i<info.photos.photo.length;i++) {
       var item = info.photos.photo[i];
       var url = 'https://farm'+item.farm+".staticflickr.com/"+item.server
                      +'/'+item.id+'_'+item.secret+'_m.jpg';
       console.debug(url);
       $("#imagenes").append($("<img/>").attr("src",url));
       $("#imagenes").append($("<p> Etiqueta = "+tag+"</p>"));
    }
    $('div.formu').slideUp(1000);
}



