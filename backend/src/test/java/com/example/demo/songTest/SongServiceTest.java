// package com.example.demo.songTest;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertThrows;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;

// import com.example.demo.song.Song;
// import com.example.demo.song.SongRepository;
// import com.example.demo.song.SongService;
// import com.example.demo.user.User;

// @SpringBootTest
// public class SongServiceTest {
    
//     private SongRepository songRepository;
//     private SongService songService;

//     @BeforeEach
//     void setUp(){
//         songRepository = mock(SongRepository.class);
//         songService = new SongService(songRepository);
//     }

//     @Test
//     void testGetSongs(){
//         List<Song> mockSongs = List.of(
//             new Song("Sandstorm", "Darude", 360, 10, "Trance"), 
//             new Song("Money Trees", "Kendrick Lamar", 300, 12, "Rap")
//             );
        
//         when(songRepository.findAll()).thenReturn(mockSongs);

//         List<Song> res = songService.getSongs();

//         assertEquals(mockSongs, res);
//     }

//     @Test
//     void testGetSong(){
//         Song mockSong = new Song("Sandstorm", "Darude", 360, 10, "Trance");
//         when(songRepository.findById(1L)).thenReturn(Optional.of(mockSong));

//         Song res = songService.getSong(1L);

//         assertEquals(mockSong, res);
//     }

//     //???
//     @Test
//     void testGetSongNotFound(){
//         when(songRepository.findById(1L)).thenReturn(Optional.empty());

//         IllegalStateException exc = assertThrows(IllegalStateException.class, () -> {
//             songService.getSong(1L);
//         });

//         assertEquals("song with id 1 does not exists", exc.getMessage());

//         verify(songRepository, times(1)).findById(1L);
//     }

//     // @Test
//     // void testGetSongsByUser(){
//     //     List<Song> mockSongs = List.of(
//     //         new Song("Sandstorm", "Darude", 360, 10, "Trance")
//     //         , 
//     //         new Song("Money Trees", "Kendrick Lamar", 300, 12, "Rap")
//     //         );
            

//     //     List<Song> res = songService.getSongsByUser(1L);

//     //     assertEquals(mockSongs, res);
//     // }

// }
