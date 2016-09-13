//
//  ViewController.swift
//  Bits of Neuro
//
//  Created by Fuji Robledo on 9/8/16.
//  Copyright © 2016 Fuji Robledo. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    @IBOutlet weak var neuronImage: UIImageView!
    
    @IBOutlet weak var typeOfCellLabel: UILabel!
    
    @IBOutlet weak var neuronTypeControl: UISegmentedControl!
    
    @IBOutlet weak var capitalSwitch: UISwitch!
    
    @IBOutlet weak var sizeOfFont: UILabel!
    
    @IBAction func changeNeuronType(sender: UISegmentedControl) {
        
        if neuronTypeControl.selectedSegmentIndex == 0 {
            typeOfCellLabel.text = "Sensory Neuron"
            neuronImage.image=UIImage(named: "sensory")
            typeOfCellLabel.textColor = UIColor.blueColor()
        }
        
        else if neuronTypeControl.selectedSegmentIndex == 1{
            typeOfCellLabel.text = "Motor Neuron"
            neuronImage.image = UIImage(named: "motor")
            typeOfCellLabel.textColor = UIColor.darkGrayColor()
        }
        
        updateCaps()
        
    }
    
    
    @IBAction func capitalizeFont(sender: UISwitch) {
        updateCaps()
    }
    
    
    func updateCaps(){
        if capitalSwitch.on {
            typeOfCellLabel.text=typeOfCellLabel.text?.uppercaseString
    }
        else {
            typeOfCellLabel.text = typeOfCellLabel.text?.lowercaseString
        }
    }
    
    
    @IBAction func changeFontSize(sender: UISlider) {
        let fontSize = sender.value
        sizeOfFont.text = String(format: "%.0f" , fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        typeOfCellLabel.font = UIFont.systemFontOfSize(fontSizeCGFloat)
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

