//
//  ViewController.swift
//  Random Number Generator Creation
//
//  Created by Fuji Robledo on 9/29/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    
    @IBOutlet weak var display: UILabel!
    
    
    @IBAction func randomNumberGenerator(sender: UIButton) {
        let RandomNumberGen = arc4random_uniform(11)
        display.text = String(RandomNumberGen)
        
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

