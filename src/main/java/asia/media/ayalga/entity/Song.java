/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asia.media.ayalga.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kbuty
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    
    @Id
    private String name;
    
    @Lob
    @Column(length = 100000)
    private byte [] data;
    
}
