package models

import java.util.Date

/**
  * Created by vasilisck on 6/27/17.
  */
case class Killmail(solarSystem: SolarSystem,
                    killID: Long,
                    killTime: Date,
                    attackers: List[Attacker],
                    attackerCount: Int,
                    victim: Victim,
                    killID_str: String,
                    attackerCount_str: String,
                    war: War
                   )

case class Attacker(alliance: ItemType,
                    shipType: ItemType,
                    corporation: ItemType,
                    character: Character,
                    damageDone: Long,
                    damageDone_str: String,
                    weaponType: ItemType,
                    finalBlow: Boolean,
                    securityStatus: Float)

case class Victim(alliance: ItemType,
                  damageTaken: Long,
                  damageTaken_str: String,
                  items: List[Item],
                  character: ItemType,
                  shipType: ItemType,
                  corporation: ItemType,
                  position: Position
                 )

case class Item(singleton: Long,
                singleton_str: String,
                itemType: ItemType,
                flag: Long,
                flag_str: String,
                quantityDestroyed: Int = 0,
                quantityDestroyed_str: String = "0",
                quantityDropped: Int = 0,
                quantityDropped_str: String = "0")

case class ItemType(id: Long, id_str: String, href: String, name: String, icon: Icon)

case class SolarSystem(id: Long, id_str: String, href: String, name: String)

case class Position(x: Double, y: Double, z: Double)

case class War(id: Long, id_str: String, href: String)

case class Icon(href: String)
