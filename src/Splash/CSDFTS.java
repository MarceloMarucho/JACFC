/**                CCCCC    SSSSSS  DDDDDD   FFFFFFF  TTTTTT    SSSSSS 
                  CC   CC  SS       DD   DD  FF         TT     SS      
                  CC       SS       DD   DD  FF         TT     SS      
                  CC        SSSSS   DD   DD  FFFFF      TT      SSSSS  
                  CC            SS  DD   DD  FF         TT          SS 
                  CC   CC       SS  DD   DD  FF         TT          SS 
                   CCCCC   SSSSSS   DDDDDD   FF         TT     SSSSSS  

                  Classical Solvation Density Functional Theory Solver              
                                     Developed by                                  
                        The University of Texas at San Antonio                     
                                     Version: 1.0                                                    

CSDFTS --  Classical Solvation Density Functional Theory Solver
Department of Physics & Astronomy
University of Texas at San Antonio Texas
Copyright (c) 2017. University of Texas at San Antonio. All rights reserved.  

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met: 

* Redistributions of source code must retain the above copyright notice, this
  list of conditions and the following disclaimer.  
* Redistributions in binary form must reproduce the above copyright notice,
  this list of conditions and the following disclaimer in the documentation
  and/or other materials provided with the distribution.
* Neither the name of the University oof Texas at San Antonio nor the names of 
  its contributors may be used to endorse or promote products derived from this
  software without specific prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
  "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
  LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
  A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Procedure Name: Main
 * @author Esteban Valderrama and Marcelo Marucho
 * Description: This is the main file.
 *
 *****************************************************************************/

package Splash;

public class CSDFTS {

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {     
                SplashScreenUI splashScreen = new SplashScreenUI();
                splashScreen.setVisible(true);
            }
        });
    }
}