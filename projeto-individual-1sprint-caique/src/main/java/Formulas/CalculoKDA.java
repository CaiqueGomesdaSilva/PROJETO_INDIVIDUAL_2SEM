/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Formulas;

/**
 *
 * @author Caiqu
 */
public class CalculoKDA {
    public int quantidadeKills;
    public int quantidadeDeath;
    public int quantidadeAssistence;
    
    public double resultadoKDA() {
        double calculo = (quantidadeKills + quantidadeAssistence) / quantidadeDeath;
        return calculo;
    }
}
