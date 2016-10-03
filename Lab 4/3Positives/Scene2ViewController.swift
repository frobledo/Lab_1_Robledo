//
//  Scene2ViewController.swift
//  3Positives
//
//  Created by Fuji Robledo on 10/2/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class Scene2ViewController: UIViewController, UITextFieldDelegate{

    @IBOutlet weak var userOnePositive: UITextField!
    @IBOutlet weak var userTwoPositive: UITextField!
    @IBOutlet weak var userThreePositive: UITextField!
    
    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?){
        if segue.identifier == "doneList" {
            let scene1ViewController = segue.destinationViewController as! ViewController
            if userOnePositive.text?.isEmpty == false {
                scene1ViewController.user.onePositiveThing=userOnePositive.text
            }
            if userTwoPositive.text?.isEmpty == false {
                scene1ViewController.user.twoPositiveThing=userTwoPositive.text
            }
            if userThreePositive.text?.isEmpty == false {
                scene1ViewController.user.threePositiveThing=userThreePositive.text
            }
        }
    }
    
    
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    override func viewDidLoad() {
        userOnePositive.delegate=self
        userTwoPositive.delegate=self
        userThreePositive.delegate=self
    }
}
