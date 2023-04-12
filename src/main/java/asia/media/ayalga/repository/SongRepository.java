/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asia.media.ayalga.repository;

import asia.media.ayalga.entity.Song;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kbuty
 */
public interface SongRepository extends JpaRepository<Song, String>{
    
    @Query(nativeQuery = true, value="SELECT name FROM song")
    List<String> getAllEntryNames();
    
}
