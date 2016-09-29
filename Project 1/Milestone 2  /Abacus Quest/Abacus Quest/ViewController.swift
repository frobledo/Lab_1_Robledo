//
//  ViewController.swift
//  Abacus Quest
//
//  Created by Fuji Robledo on 9/28/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    //Both these labels represent the operands that will be used in the problem. A random number generator will determine their values.
    @IBOutlet weak var operand1: UILabel!
    @IBOutlet weak var operand2: UILabel!
    
    //This label represents the operator, which will also be determined by the random number generator
    @IBOutlet weak var operatorChoice: UILabel!
    
    //Create a random number function to decide the operands and operator 
    //Depending on level of difficulty selected, the function will randomnly pick numbers from 0-10 (level: easy) or 0-100 (level: hard)
    //To decide on the operator, the function will randomnly selected from 0-2 (0: addition, 1: subtraction, 2: multiplication) 
    //Once the operands and operators have been selected, the program will compute the problem to compare with what the user entered
    //If the user does not answer the question right, they will have the opportunity to re-enter an answer 3 times (will use a loop). After the third time, the correct result will be shown
    //If the user answers the question correctly, a new operation will be shown
    
    //This label will notify the user of whether or not their response is correct
    @IBOutlet weak var feedback: UILabel!
    
    
    //This function will control the segmented control - will be dependent on difficulty level selected by the user
    @IBAction func chooseDifficultyLevel(sender: UISegmentedControl) {
    }
    
    
   
    //This function will evaluate the answer user entered in text field
    //The function will evaluate that the answer is an int prior to comparing the answer to the solution. If the answer is not an int, the user will receive an alert
    @IBAction func submitAnswer(sender: AnyObject) {
    }
    
    //Will need to implement a function that will dismiss the keyboard. The keyboard will be dismissed when the user clicks outside the keyboard 
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}
 /*
 RESOURCES:
 
 All images purchased from Digital Juice
 
 To generate random numbers consulted:
 https://www.youtube.com/watch?v=fWs74t9JK54
 
 
 */
