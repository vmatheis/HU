/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eratosthenesprimesieve;

import java.util.Scanner;

/**
 *
 * @author vmatheis
 */
public class EratosthenesPrimeSieve implements PrimeSieve {

    int border;
    boolean[] prims;

    public EratosthenesPrimeSieve(int p) {
        border = p;
        prims = new boolean[border + 1];
    }

    public static void main(String[] args) {
        
    }

    //1. Beispiel
    @Override
    public boolean isPrime(int p) {
        boolean isprim = false;
        boolean[] prime = new boolean[p + 1];
        for (int i = 0; i < p; i++) {
            prime[i] = true;
        }

        for (int x = 2; x * x <= p; x++) {
            if (prime[p] == true) {
                for (int i = x * 2; i <= x; i += x) {
                    prime[i] = false;
                }
            }
            isprim = true;
        }

        prims = prime;
        return isprim;
    }

    @Override
    public void printPrimes() {
        
    }
}
