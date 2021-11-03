# Trabajos prácticos

## Enunciado 1:


### Description:

Un cliente nos ha solicitado crear servicios similar a Spotify.



### Entidades

#### Artist
- idArtist
- name
- genre
- image

#### Album
- idAlbum
- idArtist
- name

#### track
 -   id
 -   name
 -   idArtist
 -   idAlbum
 -   reproduction
 -   duration


#### GET /spotify/play/track/{trackId}
Incrementar el reproduction en uno, para luego realizar las metricas de cada cancion.
 
#### GET /artist/{artistId}/songs/rank
Devolver el top 5 de canciones populares del artista.


#### GET /artist/rank
Devolver el top 5 de artistas populares.


#### GET /track/rank
Devolver el top 5 de canciones populares.





### Acceptance Criteria
1. Usar lombok.
2. Usar streams.
3. Usar optional.
4. Usar Validator.
6. Crear collection en postman.
7. Crear adviceController
8. Crear exceptions custom
9. Crear nuevo repo llamado `spotify-service`
10. Crear el swagger de los endpoints que se van a implementar
    - POST /artist
    - PUT /artist/{artistId}
    - GET /artist/{artistId}
    - DELETE /artist/{artistId}
   - POST /album
   - PUT /album/{albumId}
   - GET /album/{albumId}
   - DELETE /album/{artistId}
   - POST /track
   - PUT /track/{trackId}
   - GET /track/{trackId}
   - DELETE /track/{artistId}
   - GET /spotify/play/track/{trackId}
   - GET /artist/{artistId}/songs/rank
   - GET /artist/rank
   - GET /track/rank
    
3. Crear un nuevo proyecto llamado spotify-service.
4. Realizar la implementacion con springboot.
5. Crear pull request.
6. Crear interfaces para cada servicio.

