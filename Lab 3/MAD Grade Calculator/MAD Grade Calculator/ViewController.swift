//
//  ViewController.swift
//  MAD Grade Calculator
//
//  Created by Fuji Robledo on 9/20/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    @IBOutlet weak var projectsGrade: UITextField!
    
    @IBOutlet weak var quizzesGrade: UITextField!
    
    @IBOutlet weak var labsGrade: UITextField!
    
    @IBOutlet weak var midtermGrade: UITextField!
    
    @IBOutlet weak var finalPracticumGrade: UITextField!
    
    @IBOutlet weak var finalGrade: UILabel!
    
    
    @IBAction func textFieldDoneEditing(sender: UITextField) {
        sender.resignFirstResponder()
        
    }
    
    @IBAction func gestureRecognize(sender: AnyObject) {
        projectsGrade.resignFirstResponder()
        quizzesGrade.resignFirstResponder()
        labsGrade.resignFirstResponder()
        midtermGrade.resignFirstResponder()
        finalPracticumGrade.resignFirstResponder()
    }
   
    
    
    func calculateFinalGrade() -> Float {
        
        var projectNum:Float
        var quizzesNum:Float
        var labNum:Float
        var midtermNum:Float
        var finalNum:Float
    
        
        if projectsGrade.text!.isEmpty{
            projectNum = 0.0
        } else {
            projectNum = Float(projectsGrade.text!)!
        }
        
        
        if quizzesGrade.text!.isEmpty{
            quizzesNum = 0.0
        } else {
            quizzesNum = Float(quizzesGrade.text!)!
        }
        
        
        if labsGrade.text!.isEmpty{
            labNum = 0.0
        } else{
            labNum = Float(labsGrade.text!)!
        }
        
        
        if midtermGrade.text!.isEmpty{
            midtermNum = 0.0
        } else{
            midtermNum = Float(midtermGrade.text!)!
        }
        
        
        if finalPracticumGrade.text!.isEmpty{
            finalNum = 0.0
        } else{
            finalNum = Float(finalPracticumGrade.text!)!
        }
    
        let calculatedFinalGrade=((projectNum*0.45)+(quizzesNum*0.10)+(labNum*0.25)+(midtermNum*0.10)+(finalNum*0.10))
        
        if calculatedFinalGrade<=0 {
            let alert=UIAlertController(title: "Warning", message: "Double check your entries. The math is not adding up!", preferredStyle: UIAlertControllerStyle.Alert)
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertActionStyle.Cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.Default, handler: nil)
            alert.addAction(okAction)
        }
        
        
        return calculatedFinalGrade
    
    }
    
    
    @IBAction func finalGradeDisplay(sender: UIButton) {
        let grade = calculateFinalGrade()
        
        let alert = UIAlertController(title: "Are you sure?", message: "Take a deep breath", preferredStyle: UIAlertControllerStyle.Alert)
        
        let cancelAction = UIAlertAction(title: "Nevermind!", style: UIAlertActionStyle.Cancel, handler: nil)
        alert.addAction(cancelAction)
        
        let okAction = UIAlertAction(title: "See my grade", style: UIAlertActionStyle.Default, handler: {action in
            self.finalGrade.text=String(grade)})
        alert.addAction(okAction)
        
        presentViewController(alert, animated: true, completion: nil)
    
        
    }
    


    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        projectsGrade.delegate=self
        quizzesGrade.delegate=self
        labsGrade.delegate=self
        midtermGrade.delegate=self
        finalPracticumGrade.delegate=self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

