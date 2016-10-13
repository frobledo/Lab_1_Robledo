//
//  ViewController.swift
//  Midterm Robledo
//
//  Created by Fuji Robledo on 10/13/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    @IBOutlet weak var enteredMinutes: UITextField!
    @IBOutlet weak var showWeeklySwitch: UISwitch!
    @IBOutlet weak var workoutsSlider: UISlider!
    @IBOutlet weak var typeOfWorkOut: UISegmentedControl!
    @IBOutlet weak var milesLabel: UILabel!
    @IBOutlet weak var caloriesLabel: UILabel!
    @IBOutlet weak var workoutImage: UIImageView!
    
    @IBAction func unwindSegue(segue: UIStoryboardSegue){
        
    }
    
    @IBAction func calculateWorkout(sender: UIButton) {
        var minutes: Float
        
        if enteredMinutes.text!.isEmpty{
            minutes = 0.0
        }
        else {
            minutes=Float(enteredMinutes.text!)!
        }
        
        if minutes < 30 {
            let alert=UIAlertController(title: "Warning", message: "Try to workout more than 30 minutes for the best health benefits!", preferredStyle: UIAlertControllerStyle.Alert)
            let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.Default, handler: nil)
            alert.addAction(okAction)
            presentViewController(alert, animated: true, completion: nil)
            
        }
        
        updateTypeOfWorkout()
        
    }
    
    @IBAction func setWeeklyTime(sender: UISlider) {
        let weeklyWorkout = sender.value
        
        if showWeeklySwitch.on {
            var minutes: Float
            var miles: Float
            var calories: Float
            
            if enteredMinutes.text!.isEmpty{
                minutes = 0.0
            }
            else {
                minutes=Float(enteredMinutes.text!)!
            }
            
            miles = (minutes/60) * 6 * weeklyWorkout
            calories = (minutes/60) * 600 * weeklyWorkout
            
            milesLabel.text = String(miles) + " miles"
            caloriesLabel.text = String(calories) + " calories"
        }
        

    }
    
    @IBAction func selectWorkout(sender: AnyObject) {
        updateTypeOfWorkout()
        }
    
    func updateTypeOfWorkout() {
        if typeOfWorkOut.selectedSegmentIndex == 0 {
            workoutImage.image = UIImage(named: "Run")
            var minutes: Float
            var miles: Float
            var calories: Float
            
            if enteredMinutes.text!.isEmpty{
                minutes = 0.0
            }
            else {
                minutes=Float(enteredMinutes.text!)!
            }
            
            miles = (minutes/60) * 6
            calories = (minutes/60) * 600
            
            milesLabel.text = String(miles) + " miles"
            caloriesLabel.text = String(calories) + " calories"
        }
        else if typeOfWorkOut.selectedSegmentIndex == 1 {
            workoutImage.image = UIImage(named: "Swim")
            var minutes: Float
            var miles: Float
            var calories: Float
            
            if enteredMinutes.text!.isEmpty{
                minutes = 0.0
            }
            else {
                minutes=Float(enteredMinutes.text!)!
            }
            
            miles = (minutes/60) * 4
            calories = (minutes/60) * 510
            
            milesLabel.text = String(miles) + " miles"
            caloriesLabel.text = String(calories) + " calories"
            
        }
        else if typeOfWorkOut.selectedSegmentIndex == 2 {
            workoutImage.image = UIImage(named: "Bike")
            
            var minutes: Float
            var miles: Float
            var calories: Float
            
            if enteredMinutes.text!.isEmpty{
                minutes = 0.0
            }
            else {
                minutes=Float(enteredMinutes.text!)!
            }
            
            miles = (minutes/60) * 2
            calories = (minutes/60) * 420
            
            milesLabel.text = String(miles) + " miles"
            caloriesLabel.text = String(calories) + " calories"
            
            
        }
        
    }
    
    
    
    override func touchesBegan(touches: Set<UITouch>, withEvent event: UIEvent?) {
        view.endEditing(true)
        super.touchesBegan(touches, withEvent: event)
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        typeOfWorkOut.selectedSegmentIndex == 0 
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

