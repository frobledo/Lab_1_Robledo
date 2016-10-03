//
//  ViewController.swift
//  3Positives
//
//  Created by Fuji Robledo on 10/2/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var onePositive: UILabel!
    @IBOutlet weak var twoPositive: UILabel!
    @IBOutlet weak var threePositive: UILabel!
    
    var user=Positivity() 
    
     @IBAction func unwindSegue (segue: UIStoryboardSegue){
        onePositive.text = user.onePositiveThing
        twoPositive.text = user.twoPositiveThing
        threePositive.text = user.threePositiveThing
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

