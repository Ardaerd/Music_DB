function createPlaylist() {
    var grid = document.getElementById("songs_table")
    var playlistName = document.getElementById("playlistNameBar").value
    var checkBoxes = grid.getElementsByTagName("input")
    var songsId = []
    
   

    for (var i = 0; i < checkBoxes.length; i++) {
        if (checkBoxes[i].checked) {
            var row = checkBoxes[i].parentNode.parentNode;
            console.log(row.cells[1].innerHTML + " " + row.cells[2] + " " + row.cells[3]);

            axios.get("http://localhost:8070/Songs/getSongId/" + row.cells[2] + "/" + row.cells[1].innerHTML)
                .then(response => {
                const songId = response.data;
                console.log(songId);
                songsId[i] = songId;
            })
        }
    }


    axios.post("http://localhost:8070/playlist/createPlaylist",songsId)
                .then(response => {
                const playlist = response.data;
                console.log(playlist);
            }).catch(function (error) {
                console.log(error);
              });

    
}


function printSongs(songs) {
    var tableText="<table id='songs_table'> " + 
                        "<tr> " +
                            "<th> " +
                                "Select" +
                            "</th> " + 
                            "<th> " +
                                "Artist " +
                            "</th> " +
                            "<th> " +
                                "Song " +
                            "</th> " +
                            "<th> " +
                                "Album " +
                            "</th> " +
                            "<th> " +
                                "Length " +
                            "</th> " +
                        "</tr> ";
    
    for (song of songs) {
        console.log(song.artist.name + ", " + song.name + ", " + song.album.name + ", " + song.length);
        tableText += "<tr> " +
                        "<td><input type='checkbox' id='vehicle1' name='vehicle1' value='Bike'></td> " +
                        "<td>" + song.artist.name + "</td> " +
                        "<td>" + song.name + "</td> " +
                        "<td>" + song.album.name + "</td> " +
                        "<td>" + song.length + "</td> " +
                    "</tr> ";
        
    }

    tableText += "</table>";
    console.log(tableText);
    document.getElementById("songs_table").innerHTML = tableText;
}


function printPlaylists(playlists) {
    var tableText="<table> " + 
                        "<tr> " +
                            "<th> " +
                                "Name" +
                            "</th> " + 
                            "<th> " +
                                "Song Count " +
                            "</th> " +
                            "<th> " +
                                "Length " +
                            "</th> " +
                        "</tr> ";
    
    for (playlist of playlists) {
        console.log(playlist.name + ", " + playlist.songCount + ", " + playlist.length);
        tableText += "<tr> " +
                        "<td>" + playlist.name + "</td> " +
                        "<td>" + playlist.songCount + "</td> " +
                        "<td>" + playlist.length + "</td> " +
                    "</tr> ";
        
    }

    tableText += "</table>";
    console.log(tableText);
    document.getElementById("playlists_table").innerHTML = tableText;
}


function getAllSongs() {
    axios.get("http://localhost:8070/Songs/getAllSongs")
        .then(response => {
            const allSongs = response.data;
            console.log(allSongs);
            printSongs(allSongs);
        })
}


function getAllPlaylists() {
    axios.get("http://localhost:8070/playlist/displayPlaylist")
        .then(response => {
            const allPlaylists = response.data;
            console.log(allPlaylists);
            printPlaylists(allPlaylists);
        })
}

function searchSongs() {

    var searchValue = document.getElementById('searchBar').value;

    axios.get("http://localhost:8070/Songs/searchSongByArtistOrSongName/" + searchValue)
    .then(response => {
        const allSongs = response.data;
        console.log(allSongs);
        printSongs(allSongs);
    })
}

function openWin() {
    window.open("yourplaylists.html");
  }