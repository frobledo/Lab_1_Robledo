//
//  ViewController.swift
//  Abacus Quest
//
//  Created by Fuji Robledo on 9/28/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var operand1: UILabel!
    @IBOutlet weak var operand2: UILabel!
    @IBOutlet weak var operatorChoice: UILabel!
    @IBOutlet weak var feedback: UILabel!
    @IBOutlet weak var difficultyLevel: UISegmentedControl!
    @IBOutlet weak var enteredAnswer: UITextField!
    @IBOutlet weak var scoreValue: UILabel!
    
    //global variables to store correct answer and score during the game
    var correctAnswer = 0
    var score = 0

//This function contains the main procedure for the problem
    func setProblem() {
        
        if difficultyLevel.selectedSegmentIndex == 0 {
            
            let value1 = arc4random_uniform(11)
            let value2 = arc4random_uniform(11)
            var firstValue=0
            var secondValue=0
            
            if value1 >= value2 {
                firstValue=Int(value1)
                secondValue=Int(value2)
                operand1.text = String(value1)
                operand2.text = String(value2)
            }
            else if value1 < value2 {
                firstValue=Int(value2)
                secondValue=Int(value1)
                operand2.text = String(value1)
                operand1.text = String(value2)
            }
            
            determineOperation(firstValue, y: secondValue)
        }
            
        else if difficultyLevel.selectedSegmentIndex == 1 {
            let value1 = arc4random_uniform(51)
            let value2 = arc4random_uniform(51)
            var firstValue=0
            var secondValue=0
            
            if value1 >= value2 {
                firstValue=Int(value1)
                secondValue=Int(value2)
                operand1.text = String(value1)
                operand2.text = String(value2)
            }
            else if value1 < value2 {
                firstValue=Int(value2)
                secondValue=Int(value1)
                operand2.text = String(value1)
                operand1.text = String(value2)
            }
            
            determineOperation(firstValue, y: secondValue)
        }
            
        else if difficultyLevel.selectedSegmentIndex == 2 {
            
            let value1 = arc4random_uniform(101)
            let value2 = arc4random_uniform(101)
            var firstValue=0
            var secondValue=0
            
            if value1 >= value2 {
                firstValue=Int(value1)
                secondValue=Int(value2)
                operand1.text = String(value1)
                operand2.text = String(value2)
            }
            else if value1 < value2 {
                firstValue=Int(value2)
                secondValue=Int(value1)
                operand2.text = String(value1)
                operand1.text = String(value2)
            }
            
            determineOperation(firstValue, y: secondValue)
        }

    }

    //This function sets the difficulty level specified by the user
    @IBAction func chooseDifficultyLevel(sender: UISegmentedControl) {
        setProblem()
    }
    
    //This function uses a switch statement to determine which operation to use
    func determineOperation(x:Int, y:Int){
        
        let operation = arc4random_uniform(3)
        var operationResult=0
        
        switch operation {
        case 0:
            operatorChoice.text = "+"
            operationResult = x+y
            correctAnswer=operationResult
        case 1:
            operatorChoice.text = "-"
            operationResult = x-y
            correctAnswer=operationResult
        default:
            operatorChoice.text = "x"
            operationResult = x*y
            correctAnswer=operationResult
        }
    }
    
    
//After the user clicks the button, this function will validate the answer and alert the user if an invalid answer choice was entered. If a valid choice was entered, the user's input will be checked with correct solution.
    @IBAction func submitAnswer(sender: UIButton) {
        
        
        if enteredAnswer.text!.isEmpty {
            
            let alert = UIAlertController(title: "Warning!", message: "Please enter an answer.", preferredStyle: UIAlertControllerStyle.Alert)
            
            let cancelAction = UIAlertAction(title: "OK", style: UIAlertActionStyle.Cancel, handler: nil)
            alert.addAction(cancelAction)
            
            presentViewController(alert, animated: true, completion: nil)
        }
        
        else {
            let textAnswer: String = enteredAnswer.text!
            let userAnswer = Int(textAnswer)!
            
            
            if correctAnswer == userAnswer {
                feedback.text = "Correct Answer!"
                enteredAnswer.text = ""
                score += 1
                scoreValue.text = String(score)
                setProblem()
            }
                
            else {
                
                feedback.text = "Try Again!"
                enteredAnswer.text = ""
                score -= 1
                scoreValue.text = String(score)
            }

        }
        
    }

//This function resets the problem if the user clicks on the button
    @IBAction func newProblem(sender: UIButton) {
        feedback.text = ""
        enteredAnswer.text = ""
        setProblem()
    }

//To refresh UI after restarting
    func refreshUI() {
        feedback.text = ""
        enteredAnswer.text = ""
        setProblem()
    }
    
//To remove the keyboard once the user touches the screen, the following code was used (derived from codingexplorer.com
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        view.endEditing(true)
        super.touchesBegan(touches, withEvent: event)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setProblem()
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
