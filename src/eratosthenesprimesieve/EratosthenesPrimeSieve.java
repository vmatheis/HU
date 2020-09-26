/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eratosthenesprimesieve;

import java.util.ArrayList;
import java.util.Objects;
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
         Scanner s = new Scanner(System.in, "Windows-1252");
        System.out.println("Obergrenze: ");
        int p = Integer.parseInt(s.nextLine());
        EratosthenesPrimeSieve prim = new EratosthenesPrimeSieve(p);
        prim.printPrimes();
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
            if (prime[x] == true) {
                for (int i = x * 2; i <= p; i += x) {
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
         isPrime(border);
        for (int i = 2; i <= border; i++) {
            if (prims[i] == true) {
                System.out.println("Prim: " + i);
            }
        }
    }
    
    //2. Beispiel
    public void sumPrimes(int n) {
        
        ArrayList<Integer> even = new ArrayList<>();
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                even.add(i);
            }
        }

        ArrayList<Integer> prim = new ArrayList<>();
        for (int i = 2; i <= border; i++) {
            if (prims[i] == true) {
                prim.add(i);
            }
        }
        
    }
}
