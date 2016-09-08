//
//  ViewController.swift
//  Lab_1_Robledo
//
//  Created by Fuji Robledo on 9/6/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
   

    @IBOutlet weak var motivationalQuote: UILabel!
    
    @IBOutlet weak var motivationalImage: UIImageView!
    
    
    @IBAction func relaxButton(sender: UIButton) {
        motivationalQuote.text="Tense and relax muscles"
        motivationalImage.image=UIImage(named:"relax.png")
    }
    
    
    @IBAction func laughButton(sender: UIButton) {
        motivationalQuote.text="Laughter releases endorphins"
        motivationalImage.image=UIImage(named:"laugh.png")
    }
    
    
    @IBAction func affirmButton(sender: UIButton) {
        motivationalQuote.text="You are a rockstar!"
        motivationalImage.image=UIImage(named:"affirm.png")
    }
    
    @IBAction func breatheButton(sender: AnyObject) {
        motivationalQuote.text="Take deep belly breaths"
        motivationalImage.image=UIImage(named:"breathe.png")
    }
    
    //Image citations
    //logo created by Fuji Robledo
    //loading image from pinterest
    //colorful tree from pinterest
    //relax image from ipnos soft
    //laugh image from ebay
    //affirm image pinterest
    //breathe image 
    
    //Below is the code I had attempted to avoid redundant buttons. However, nothing would occur when I would click on the button and could not figure out a good solution
    
    /*@IBAction func copingButton(sender: UIButton) {

        if sender.currentTitle=="Relax" {
            motivationalQuote.text="Tense and relax muscles"
            motivationalImage.image=UIImage(named:"daVinci_MonaLisa.png")
        }
            
        else if sender.currentTitle=="Laugh" {
            motivationalQuote.text="Laughter releases endorphins"
            motivationalImage.image=UIImage(named:"daVinci.png")
        }
            
        else if sender.currentTitle=="Affirm" {
            motivationalQuote.text="You are a rockstar!"
            motivationalImage.image=UIImage(named:"daVinci_Vitruvian.png")
        }
            
        else if sender.currentTitle=="Breathe" {
            motivationalQuote.text="Take deep belly breaths"
            motivationalImage.image=UIImage(named:"hello180.png")
        }
    }*/
    
    
   
}

