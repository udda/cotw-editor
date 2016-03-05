/*
	Copyright (C) 2011-2016 Mario Cianciolo <mr.udda@gmail.com>

	This file is part of CotW Editor.

	CotW Editor is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	CotW Editor is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with CotW Editor.  If not, see <http://www.gnu.org/licenses/>.
*/

import javolution.io.*;
import java.nio.*;
import java.nio.file.*;
import java.nio.ByteBuffer;

class Savefile extends javolution.io.PackedStruct {

/*--0x0000--*/	public final Unsigned8[]		UNK_0000		= array(new Unsigned8[0x10]);
/*--0x0010--*/	public final Unsigned8[]		UNK_0010		= array(new Unsigned8[0x10]);
/*--0x0020--*/	public final Unsigned8[]		UNK_0020		= array(new Unsigned8[0x10]);
/*--0x0030--*/	public final Unsigned8[]		UNK_0030		= array(new Unsigned8[0x10]);
/*--0x0040--*/	public final Unsigned8[]		UNK_0040		= array(new Unsigned8[0x10]);
/*--0x0050--*/	public final Unsigned8[]		UNK_0050		= array(new Unsigned8[0x10]);
/*--0x0060--*/	public final Unsigned8[]		UNK_0060		= array(new Unsigned8[0x10]);
/*--0x0070--*/	public final Unsigned8[]		UNK_0070		= array(new Unsigned8[0x10]);

/*--0x0080--*/	public final Unsigned8			stat_str_max	= new Unsigned8();
/*--0x0081--*/	public final Unsigned8			stat_int_max	= new Unsigned8();
/*--0x0082--*/	public final Unsigned8			stat_con_max	= new Unsigned8();
/*--0x0083--*/	public final Unsigned8			stat_dex_max	= new Unsigned8();
/*--0x0084--*/	public final Unsigned8			stat_str		= new Unsigned8();
/*--0x0085--*/	public final Unsigned8			stat_int		= new Unsigned8();
/*--0x0086--*/	public final Unsigned8			stat_con		= new Unsigned8();
/*--0x0087--*/	public final Unsigned8			stat_dex		= new Unsigned8();

/*--0x0088--*/	public final Unsigned8[]		UNK_0088		= array(new Unsigned8[0x08]);

/*--0x0090--*/	public final Unsigned8			bonus_str		= new Unsigned8();
/*--0x0091--*/	public final Unsigned8			bonus_int		= new Unsigned8();
/*--0x0092--*/	public final Unsigned8			bonus_con		= new Unsigned8();
/*--0x0093--*/	public final Unsigned8			bonus_dex		= new Unsigned8();
/*--0x0094--*/	public final Signed16			hp				= new Signed16();
/*--0x0096--*/	public final Signed16			hp_max			= new Signed16();
/*--0x0098--*/	public final Signed16			mana			= new Signed16();
/*--0x009A--*/	public final Signed16			mana_max		= new Signed16();
/*--0x009C--*/	public final Signed16			level			= new Signed16();
/*--0x009E--*/	public final Signed32			exp				= new Signed32();
/*--0x00A2--*/	public final Signed32			exp_max			= new Signed32(); //TODO check that
/*--0x00A6--*/	public final Signed16			stat_armor		= new Signed16();
/*--0x00A8--*/	public final Signed16			stat_hitbonus	= new Signed16(); //TODO check that
/*--0x00AA--*/	public final Signed16			stat_dmgbonus	= new Signed16(); //TODO check that

/*--0x00AC--*/	public final Unsigned8[]		UNK_00AC		= array(new Unsigned8[0x08]);

/*--0x00B4--*/	public final Unsigned8			pos_y			= new Unsigned8();
/*--0x00B5--*/	public final Unsigned8			pos_x			= new Unsigned8();
/*--0x00B6--*/	public final Unsigned8			pos_y_prev		= new Unsigned8();
/*--0x00B7--*/	public final Unsigned8			pos_x_prev		= new Unsigned8();

/*--0x00B8--*/	public final Unsigned8[]		UNK_00B8		= array(new Unsigned8[0x10]);
/*--0x00C8--*/	public final Unsigned8[]		UNK_00C8		= array(new Unsigned8[0x10]);
/*--0x00D8--*/	public final Unsigned8[]		UNK_00D8		= array(new Unsigned8[0x10]);
/*--0x00E8--*/	public final Unsigned8[]		UNK_00E8		= array(new Unsigned8[0x10]);
/*--0x00F8--*/	public final Unsigned8[]		UNK_00F8		= array(new Unsigned8[0x08]);

/*--0x0100--*/	public final UTF8String			name			= new UTF8String(64);

/*--0x0140--*/	public final Unsigned8[]		UNK_0140		= array(new Unsigned8[0x10]);

/*--0x0150--*/	public final Signed16			res_fire		= new Signed16(); //TODO check that
/*--0x0152--*/	public final Signed16			res_cold		= new Signed16(); //TODO check that
/*--0x0154--*/	public final Signed16			res_lightning	= new Signed16(); //TODO check that
/*--0x0156--*/	public final Signed16			res_acid		= new Signed16(); //TODO check that
/*--0x0158--*/	public final Signed16			res_fear		= new Signed16(); //TODO check that
/*--0x015A--*/	public final Signed16			res_drainlife	= new Signed16(); //TODO check that
/*--0x015C--*/	public final Unsigned8			levitation		= new Unsigned8(); //TODO check that

/*--0x015D--*/	public final Unsigned8[]		UNK_015D		= array(new Unsigned8[0x10]);
/*--0x016D--*/	public final Unsigned8[]		UNK_016D		= array(new Unsigned8[0x10]);
/*--0x017D--*/	public final Unsigned8[]		UNK_017D		= array(new Unsigned8[0x10]);
/*--0x018D--*/	public final Unsigned8[]		UNK_018D		= array(new Unsigned8[0x10]);
/*--0x019D--*/	public final Unsigned8[]		UNK_019D		= array(new Unsigned8[0x10]);
/*--0x01AD--*/	public final Unsigned8[]		UNK_01AD		= array(new Unsigned8[0x05]);

//spells: <0: no (default FF); >=0: si (maybe number of necessary mana; resets every level)
/*--0x01B2--*/	public final Unsigned8			spell_1			= new Unsigned8();	// Heal Minor Wounds
/*--0x01B3--*/	public final Unsigned8[]		UNK_01B3		= array(new Unsigned8[0x0B]);
/*--0x01BE--*/	public final Unsigned8			spell_2			= new Unsigned8();	// Detect Objects
/*--0x01BF--*/	public final Unsigned8[]		UNK_01BF		= array(new Unsigned8[0x0B]);
/*--0x01CA--*/	public final Unsigned8			spell_3			= new Unsigned8();	// Light
/*--0x01CB--*/	public final Unsigned8[]		UNK_01CB		= array(new Unsigned8[0x0B]);
/*--0x01D6--*/	public final Unsigned8			spell_4			= new Unsigned8();	// Magic Arrow
/*--0x01D7--*/	public final Unsigned8[]		UNK_01D7		= array(new Unsigned8[0x0B]);
/*--0x01E2--*/	public final Unsigned8			spell_5			= new Unsigned8();	// Phase Door
/*--0x01E3--*/	public final Unsigned8[]		UNK_01E3		= array(new Unsigned8[0x0B]);
/*--0x01EE--*/	public final Unsigned8			spell_6			= new Unsigned8();	// Shield
/*--0x01EF--*/	public final Unsigned8[]		UNK_01EF		= array(new Unsigned8[0x0B]);
/*--0x01FA--*/	public final Unsigned8			spell_7			= new Unsigned8();	// Clairvoyance
/*--0x01FB--*/	public final Unsigned8[]		UNK_01FB		= array(new Unsigned8[0x0B]);
/*--0x0206--*/	public final Unsigned8			spell_8			= new Unsigned8();	// Cold Bolt
/*--0x0207--*/	public final Unsigned8[]		UNK_0207		= array(new Unsigned8[0x0B]);
/*--0x0212--*/	public final Unsigned8			spell_9			= new Unsigned8();	// Detect Monsters
/*--0x0213--*/	public final Unsigned8[]		UNK_0213		= array(new Unsigned8[0x0B]);
/*--0x021E--*/	public final Unsigned8			spell_10		= new Unsigned8();	// Detect Traps
/*--0x021F--*/	public final Unsigned8[]		UNK_021F		= array(new Unsigned8[0x0B]);
/*--0x022A--*/	public final Unsigned8			spell_11		= new Unsigned8();	// Identify
/*--0x022B--*/	public final Unsigned8[]		UNK_022B		= array(new Unsigned8[0x0B]);
/*--0x0236--*/	public final Unsigned8			spell_12		= new Unsigned8();	// Levitation
/*--0x0237--*/	public final Unsigned8[]		UNK_0237		= array(new Unsigned8[0x0B]);
/*--0x0242--*/	public final Unsigned8			spell_13		= new Unsigned8();	// Neutralize Poison
/*--0x0243--*/	public final Unsigned8[]		UNK_0243		= array(new Unsigned8[0x0B]);
/*--0x024E--*/	public final Unsigned8			spell_14		= new Unsigned8();	// Cold Ball
/*--0x024F--*/	public final Unsigned8[]		UNK_024F		= array(new Unsigned8[0x0B]);
/*--0x025A--*/	public final Unsigned8			spell_15		= new Unsigned8();	// Heal Medium Wounds
/*--0x025B--*/	public final Unsigned8[]		UNK_025B		= array(new Unsigned8[0x0B]);
/*--0x0266--*/	public final Unsigned8			spell_16		= new Unsigned8();	// Fire Bolt
/*--0x0267--*/	public final Unsigned8[]		UNK_0267		= array(new Unsigned8[0x0B]);
/*--0x0272--*/	public final Unsigned8			spell_17		= new Unsigned8();	// Lightning
/*--0x0273--*/	public final Unsigned8[]		UNK_0273		= array(new Unsigned8[0x0B]);
/*--0x027E--*/	public final Unsigned8			spell_18		= new Unsigned8();	// Remove Curse
/*--0x027F--*/	public final Unsigned8[]		UNK_027F		= array(new Unsigned8[0x0B]);
/*--0x028A--*/	public final Unsigned8			spell_19		= new Unsigned8();	// Resist Fire
/*--0x028B--*/	public final Unsigned8[]		UNK_028B		= array(new Unsigned8[0x0B]);
/*--0x0296--*/	public final Unsigned8			spell_20		= new Unsigned8();	// Resist Cold
/*--0x0297--*/	public final Unsigned8[]		UNK_0297		= array(new Unsigned8[0x0B]);
/*--0x02A2--*/	public final Unsigned8			spell_21		= new Unsigned8();	// Resist Lightning
/*--0x02A3--*/	public final Unsigned8[]		UNK_02A3		= array(new Unsigned8[0x0B]);
/*--0x02AE--*/	public final Unsigned8			spell_22		= new Unsigned8();	// Resist Acid
/*--0x02AF--*/	public final Unsigned8[]		UNK_02AF		= array(new Unsigned8[0x0B]);
/*--0x02BA--*/	public final Unsigned8			spell_23		= new Unsigned8();	// Resist Fear
/*--0x02BB--*/	public final Unsigned8[]		UNK_02BB		= array(new Unsigned8[0x0B]);
/*--0x02C6--*/	public final Unsigned8			spell_24		= new Unsigned8();	// Sleep Monster
/*--0x02C7--*/	public final Unsigned8[]		UNK_02C7		= array(new Unsigned8[0x0B]);
/*--0x02D2--*/	public final Unsigned8			spell_25		= new Unsigned8();	// Slow Monster
/*--0x02D3--*/	public final Unsigned8[]		UNK_02D3		= array(new Unsigned8[0x0B]);
/*--0x02DE--*/	public final Unsigned8			spell_26		= new Unsigned8();	// Teleport
/*--0x02DF--*/	public final Unsigned8[]		UNK_02DF		= array(new Unsigned8[0x0B]);
/*--0x02EA--*/	public final Unsigned8			spell_27		= new Unsigned8();	// Rune of Return
/*--0x02EB--*/	public final Unsigned8[]		UNK_02EB		= array(new Unsigned8[0x0B]);
/*--0x02F6--*/	public final Unsigned8			spell_28		= new Unsigned8();	// Heal Major Wounds
/*--0x02F7--*/	public final Unsigned8[]		UNK_02F7		= array(new Unsigned8[0x0B]);
/*--0x0302--*/	public final Unsigned8			spell_29		= new Unsigned8();	// Fireball
/*--0x0303--*/	public final Unsigned8[]		UNK_0303		= array(new Unsigned8[0x0B]);
/*--0x030E--*/	public final Unsigned8			spell_30		= new Unsigned8();	// Ball Lightning
/*--0x030F--*/	public final Unsigned8[]		UNK_030F		= array(new Unsigned8[0x0B]);
/*--0x031A--*/	public final Unsigned8			spell_31		= new Unsigned8();	// Healing
/*--0x031B--*/	public final Unsigned8[]		UNK_031B		= array(new Unsigned8[0x0B]);
/*--0x0326--*/	public final Unsigned8			spell_32		= new Unsigned8();	// Transmogrify Monster
/*--0x0327--*/	public final Unsigned8[]		UNK_0327		= array(new Unsigned8[0x0B]);
/*--0x0332--*/	public final Unsigned8			spell_33		= new Unsigned8();	// Create Traps
/*--0x0333--*/	public final Unsigned8[]		UNK_0333		= array(new Unsigned8[0x0B]);
/*--0x033E--*/	public final Unsigned8			spell_34		= new Unsigned8();	// Clone Monster
/*--0x033F--*/	public final Unsigned8[]		UNK_033F		= array(new Unsigned8[0x0B]);
/*--0x034A--*/	public final Unsigned8			spell_35		= new Unsigned8();	// Haste Monster
/*--0x034B--*/	public final Unsigned8[]		UNK_034B		= array(new Unsigned8[0x0B]);
/*--0x0356--*/	public final Unsigned8			spell_36		= new Unsigned8();	// Teleport Away
/*--0x0357--*/	public final Unsigned8[]		UNK_0357		= array(new Unsigned8[0x0B]);

/*--0x0363--*/	public final Unsigned8[]		UNK_0363		= array(new Unsigned8[0x10]);
/*--0x0373--*/	public final Unsigned8[]		UNK_0373		= array(new Unsigned8[0x10]);
/*--0x0383--*/	public final Unsigned8[]		UNK_0383		= array(new Unsigned8[0x10]);
/*--0x0393--*/	public final Unsigned8[]		UNK_0393		= array(new Unsigned8[0x10]);
/*--0x03A3--*/	public final Unsigned8[]		UNK_03A3		= array(new Unsigned8[0x10]);
/*--0x03B3--*/	public final Unsigned8[]		UNK_03B3		= array(new Unsigned8[0x10]);
/*--0x03C3--*/	public final Unsigned8[]		UNK_03C3		= array(new Unsigned8[0x05]);

/*--0x03A2--*/	public final UTF8String			custicon_path	= new UTF8String(25);

/*--0x03C7--*/	public final Unsigned8[]		UNK_03C7		= array(new Unsigned8[0x10]);
/*--0x02D7--*/	public final Unsigned8[]		UNK_03D7		= array(new Unsigned8[0x10]);
/*--0x03E7--*/	public final Unsigned8[]		UNK_03E7		= array(new Unsigned8[0x10]);
/*--0x03F7--*/	public final Unsigned8[]		UNK_03F7		= array(new Unsigned8[0x10]);
/*--0x0407--*/	public final Unsigned8[]		UNK_0407		= array(new Unsigned8[0x10]);
/*--0x0417--*/	public final Unsigned8[]		UNK_0417		= array(new Unsigned8[0x10]);
/*--0x0427--*/	public final Unsigned8[]		UNK_0427		= array(new Unsigned8[0x10]);
/*--0x0437--*/	public final Unsigned8[]		UNK_0437		= array(new Unsigned8[0x10]);
/*--0x0447--*/	public final Unsigned8[]		UNK_0447		= array(new Unsigned8[0x10]);
/*--0x0457--*/	public final Unsigned8[]		UNK_0457		= array(new Unsigned8[0x10]);
/*--0x0467--*/	public final Unsigned8[]		UNK_0467		= array(new Unsigned8[0x10]);
/*--0x0477--*/	public final Unsigned8[]		UNK_0477		= array(new Unsigned8[0x10]);
/*--0x0487--*/	public final Unsigned8[]		UNK_0487		= array(new Unsigned8[0x10]);
/*--0x0497--*/	public final Unsigned8[]		UNK_0497		= array(new Unsigned8[0x10]);
/*--0x04A7--*/	public final Unsigned8[]		UNK_04A7		= array(new Unsigned8[0x10]);
/*--0x04B7--*/	public final Unsigned8[]		UNK_04B7		= array(new Unsigned8[0x10]);
/*--0x04C7--*/	public final Unsigned8[]		UNK_04C7		= array(new Unsigned8[0x10]);
/*--0x04D7--*/	public final Unsigned8[]		UNK_04D7		= array(new Unsigned8[0x06]);

/*--0x04F6--*/	public final Unsigned16			copper			= new Unsigned16();

/*--0x04F8--*/	public final Unsigned8[]		UNK_04F8		= array(new Unsigned8[0x10]);
/*--0x0508--*/	public final Unsigned8[]		UNK_0508		= array(new Unsigned8[0x10]);
/*--0x0518--*/	public final Unsigned8[]		UNK_0518		= array(new Unsigned8[0x10]);
/*--0x0528--*/	public final Unsigned8[]		UNK_0528		= array(new Unsigned8[0x10]);
/*--0x0538--*/	public final Unsigned8[]		UNK_0538		= array(new Unsigned8[0x10]);
/*--0x0548--*/	public final Unsigned8[]		UNK_0548		= array(new Unsigned8[0x10]);
/*--0x0558--*/	public final Unsigned8[]		UNK_0558		= array(new Unsigned8[0x10]);
/*--0x0568--*/	public final Unsigned8[]		UNK_0568		= array(new Unsigned8[0x04]);

/*--0x056C--*/	public final Unsigned8			difficulty		= new Unsigned8();

/*--0x056D--*/	public final Unsigned8[]		UNK_056D		= array(new Unsigned8[0x10]);
/*--0x057D--*/	public final Unsigned8[]		UNK_057D		= array(new Unsigned8[0x10]);
/*--0x058D--*/	public final Unsigned8[]		UNK_058D		= array(new Unsigned8[0x10]);
/*--0x059D--*/	public final Unsigned8[]		UNK_059D		= array(new Unsigned8[0x10]);
/*--0x05AD--*/	public final Unsigned8[]		UNK_05AD		= array(new Unsigned8[0x10]);
/*--0x05BD--*/	public final Unsigned8[]		UNK_05BD		= array(new Unsigned8[0x10]);
/*--0x05CD--*/	public final Unsigned8[]		UNK_05CD		= array(new Unsigned8[0x10]);
/*--0x05DD--*/	public final Unsigned8[]		UNK_05DD		= array(new Unsigned8[0x10]);
/*--0x05ED--*/	public final Unsigned8[]		UNK_05ED		= array(new Unsigned8[0x10]);
/*--0x05FD--*/	public final Unsigned8[]		UNK_05FD		= array(new Unsigned8[0x10]);
/*--0x060D--*/	public final Unsigned8[]		UNK_060D		= array(new Unsigned8[0x10]);
/*--0x061D--*/	public final Unsigned8[]		UNK_061D		= array(new Unsigned8[0x10]);
/*--0x062D--*/	public final Unsigned8[]		UNK_062D		= array(new Unsigned8[0x10]);
/*--0x063D--*/	public final Unsigned8[]		UNK_063D		= array(new Unsigned8[0x10]);
/*--0x064D--*/	public final Unsigned8[]		UNK_064D		= array(new Unsigned8[0x10]);
/*--0x065D--*/	public final Unsigned8[]		UNK_065D		= array(new Unsigned8[0x10]);
/*--0x066D--*/	public final Unsigned8[]		UNK_066D		= array(new Unsigned8[0x10]);
/*--0x067D--*/	public final Unsigned8[]		UNK_067D		= array(new Unsigned8[0x10]);
/*--0x068D--*/	public final Unsigned8[]		UNK_068D		= array(new Unsigned8[0x10]);
/*--0x069D--*/	public final Unsigned8[]		UNK_069D		= array(new Unsigned8[0x10]);
/*--0x06AD--*/	public final Unsigned8[]		UNK_06AD		= array(new Unsigned8[0x10]);
/*--0x06BD--*/	public final Unsigned8[]		UNK_06BD		= array(new Unsigned8[0x10]);
/*--0x06CD--*/	public final Unsigned8[]		UNK_06CD		= array(new Unsigned8[0x10]);
/*--0x06DD--*/	public final Unsigned8[]		UNK_06DD		= array(new Unsigned8[0x10]);
/*--0x06ED--*/	public final Unsigned8[]		UNK_06ED		= array(new Unsigned8[0x10]);
/*--0x06FD--*/	public final Unsigned8[]		UNK_06FD		= array(new Unsigned8[0x10]);
/*--0x070D--*/	public final Unsigned8[]		UNK_070D		= array(new Unsigned8[0x10]);
/*--0x071D--*/	public final Unsigned8[]		UNK_071D		= array(new Unsigned8[0x10]);
/*--0x072D--*/	public final Unsigned8[]		UNK_072D		= array(new Unsigned8[0x10]);
/*--0x073D--*/	public final Unsigned8[]		UNK_073D		= array(new Unsigned8[0x10]);
/*--0x074D--*/	public final Unsigned8[]		UNK_074D		= array(new Unsigned8[0x10]);
/*--0x075D--*/	public final Unsigned8[]		UNK_075D		= array(new Unsigned8[0x10]);
/*--0x076D--*/	public final Unsigned8[]		UNK_076D		= array(new Unsigned8[0x10]);
/*--0x077D--*/	public final Unsigned8[]		UNK_077D		= array(new Unsigned8[0x10]);
/*--0x078D--*/	public final Unsigned8[]		UNK_078D		= array(new Unsigned8[0x10]);
/*--0x079D--*/	public final Unsigned8[]		UNK_079D		= array(new Unsigned8[0x10]);
/*--0x07AD--*/	public final Unsigned8[]		UNK_07AD		= array(new Unsigned8[0x10]);
/*--0x07BD--*/	public final Unsigned8[]		UNK_07BD		= array(new Unsigned8[0x10]);
/*--0x07CD--*/	public final Unsigned8[]		UNK_07CD		= array(new Unsigned8[0x10]);
/*--0x07DD--*/	public final Unsigned8[]		UNK_07DD		= array(new Unsigned8[0x10]);
/*--0x07ED--*/	public final Unsigned8[]		UNK_07ED		= array(new Unsigned8[0x10]);
/*--0x07FD--*/	public final Unsigned8[]		UNK_07FD		= array(new Unsigned8[0x10]);
/*--0x080D--*/	public final Unsigned8[]		UNK_080D		= array(new Unsigned8[0x10]);
/*--0x081D--*/	public final Unsigned8[]		UNK_081D		= array(new Unsigned8[0x10]);
/*--0x082D--*/	public final Unsigned8[]		UNK_082D		= array(new Unsigned8[0x10]);
/*--0x083D--*/	public final Unsigned8[]		UNK_083D		= array(new Unsigned8[0x10]);
/*--0x084D--*/	public final Unsigned8[]		UNK_084D		= array(new Unsigned8[0x10]);
/*--0x085D--*/	public final Unsigned8[]		UNK_085D		= array(new Unsigned8[0x10]);
/*--0x086D--*/	public final Unsigned8[]		UNK_086D		= array(new Unsigned8[0x10]);
/*--0x087D--*/	public final Unsigned8[]		UNK_087D		= array(new Unsigned8[0x10]);
/*--0x088D--*/	public final Unsigned8[]		UNK_088D		= array(new Unsigned8[0x10]);
/*--0x089D--*/	public final Unsigned8[]		UNK_089D		= array(new Unsigned8[0x10]);
/*--0x08AD--*/	public final Unsigned8[]		UNK_08AD		= array(new Unsigned8[0x10]);
/*--0x08BD--*/	public final Unsigned8[]		UNK_08BD		= array(new Unsigned8[0x10]);
/*--0x08CD--*/	public final Unsigned8[]		UNK_08CD		= array(new Unsigned8[0x10]);
/*--0x08DD--*/	public final Unsigned8[]		UNK_08DD		= array(new Unsigned8[0x10]);
/*--0x08ED--*/	public final Unsigned8[]		UNK_08ED		= array(new Unsigned8[0x10]);
/*--0x08FD--*/	public final Unsigned8[]		UNK_08FD		= array(new Unsigned8[0x10]);
/*--0x090D--*/	public final Unsigned8[]		UNK_090D		= array(new Unsigned8[0x10]);
/*--0x091D--*/	public final Unsigned8[]		UNK_091D		= array(new Unsigned8[0x10]);
/*--0x092D--*/	public final Unsigned8[]		UNK_092D		= array(new Unsigned8[0x10]);
/*--0x093D--*/	public final Unsigned8[]		UNK_093D		= array(new Unsigned8[0x10]);
/*--0x094D--*/	public final Unsigned8[]		UNK_094D		= array(new Unsigned8[0x10]);
/*--0x095D--*/	public final Unsigned8[]		UNK_095D		= array(new Unsigned8[0x10]);
/*--0x096D--*/	public final Unsigned8[]		UNK_096D		= array(new Unsigned8[0x10]);
/*--0x097D--*/	public final Unsigned8[]		UNK_097D		= array(new Unsigned8[0x10]);
/*--0x098D--*/	public final Unsigned8[]		UNK_098D		= array(new Unsigned8[0x10]);
/*--0x099D--*/	public final Unsigned8[]		UNK_099D		= array(new Unsigned8[0x10]);
/*--0x09AD--*/	public final Unsigned8[]		UNK_09AD		= array(new Unsigned8[0x10]);
/*--0x09BD--*/	public final Unsigned8[]		UNK_09BD		= array(new Unsigned8[0x10]);
/*--0x09CD--*/	public final Unsigned8[]		UNK_09CD		= array(new Unsigned8[0x10]);
/*--0x09DD--*/	public final Unsigned8[]		UNK_09DD		= array(new Unsigned8[0x10]);
/*--0x09ED--*/	public final Unsigned8[]		UNK_09ED		= array(new Unsigned8[0x10]);
/*--0x09FD--*/	public final Unsigned8[]		UNK_09FD		= array(new Unsigned8[0x10]);
/*--0x0A0D--*/	public final Unsigned8[]		UNK_0A0D		= array(new Unsigned8[0x10]);
/*--0x0A1D--*/	public final Unsigned8[]		UNK_0A1D		= array(new Unsigned8[0x10]);
/*--0x0A2D--*/	public final Unsigned8[]		UNK_0A2D		= array(new Unsigned8[0x10]);
/*--0x0A3D--*/	public final Unsigned8[]		UNK_0A3D		= array(new Unsigned8[0x10]);
/*--0x0A4D--*/	public final Unsigned8[]		UNK_0A4D		= array(new Unsigned8[0x10]);
/*--0x0A5D--*/	public final Unsigned8[]		UNK_0A5D		= array(new Unsigned8[0x10]);
/*--0x0A6D--*/	public final Unsigned8[]		UNK_0A6D		= array(new Unsigned8[0x10]);
/*--0x0A7D--*/	public final Unsigned8[]		UNK_0A7D		= array(new Unsigned8[0x10]);
/*--0x0A8D--*/	public final Unsigned8[]		UNK_0A8D		= array(new Unsigned8[0x10]);
/*--0x0A9D--*/	public final Unsigned8[]		UNK_0A9D		= array(new Unsigned8[0x10]);
/*--0x0AAD--*/	public final Unsigned8[]		UNK_0AAD		= array(new Unsigned8[0x10]);
/*--0x0ABD--*/	public final Unsigned8[]		UNK_0ABD		= array(new Unsigned8[0x10]);
/*--0x0ACD--*/	public final Unsigned8[]		UNK_0ACD		= array(new Unsigned8[0x10]);
/*--0x0ADD--*/	public final Unsigned8[]		UNK_0ADD		= array(new Unsigned8[0x10]);
/*--0x0AED--*/	public final Unsigned8[]		UNK_0AED		= array(new Unsigned8[0x10]);
/*--0x0AFD--*/	public final Unsigned8[]		UNK_0AFD		= array(new Unsigned8[0x10]);
/*--0x0B0D--*/	public final Unsigned8[]		UNK_0B0D		= array(new Unsigned8[0x10]);
/*--0x0B1D--*/	public final Unsigned8[]		UNK_0B1D		= array(new Unsigned8[0x10]);
/*--0x0B2D--*/	public final Unsigned8[]		UNK_0B2D		= array(new Unsigned8[0x10]);
/*--0x0B3D--*/	public final Unsigned8[]		UNK_0B3D		= array(new Unsigned8[0x10]);
/*--0x0B4D--*/	public final Unsigned8[]		UNK_0B4D		= array(new Unsigned8[0x10]);
/*--0x0B5D--*/	public final Unsigned8[]		UNK_0B5D		= array(new Unsigned8[0x10]);
/*--0x0B6D--*/	public final Unsigned8[]		UNK_0B6D		= array(new Unsigned8[0x10]);
/*--0x0B7D--*/	public final Unsigned8[]		UNK_0B7D		= array(new Unsigned8[0x10]);
/*--0x0B8D--*/	public final Unsigned8[]		UNK_0B8D		= array(new Unsigned8[0x10]);
/*--0x0B9D--*/	public final Unsigned8[]		UNK_0B9D		= array(new Unsigned8[0x10]);
/*--0x0BAD--*/	public final Unsigned8[]		UNK_0BAD		= array(new Unsigned8[0x10]);
/*--0x0BBD--*/	public final Unsigned8[]		UNK_0BBD		= array(new Unsigned8[0x10]);
/*--0x0BCD--*/	public final Unsigned8[]		UNK_0BCD		= array(new Unsigned8[0x10]);
/*--0x0BDD--*/	public final Unsigned8[]		UNK_0BDD		= array(new Unsigned8[0x10]);
/*--0x0BED--*/	public final Unsigned8[]		UNK_0BED		= array(new Unsigned8[0x10]);
/*--0x0BFD--*/	public final Unsigned8[]		UNK_0BFD		= array(new Unsigned8[0x10]);
/*--0x0C0D--*/	public final Unsigned8[]		UNK_0C0D		= array(new Unsigned8[0x10]);
/*--0x0C1D--*/	public final Unsigned8[]		UNK_0C1D		= array(new Unsigned8[0x10]);
/*--0x0C2D--*/	public final Unsigned8[]		UNK_0C2D		= array(new Unsigned8[0x10]);
/*--0x0C3D--*/	public final Unsigned8[]		UNK_0C3D		= array(new Unsigned8[0x10]);
/*--0x0C4D--*/	public final Unsigned8[]		UNK_0C4D		= array(new Unsigned8[0x10]);
/*--0x0C5D--*/	public final Unsigned8[]		UNK_0C5D		= array(new Unsigned8[0x10]);
/*--0x0C6D--*/	public final Unsigned8[]		UNK_0C6D		= array(new Unsigned8[0x10]);
/*--0x0C7D--*/	public final Unsigned8[]		UNK_0C7D		= array(new Unsigned8[0x10]);
/*--0x0C8D--*/	public final Unsigned8[]		UNK_0C8D		= array(new Unsigned8[0x10]);
/*--0x0C9D--*/	public final Unsigned8[]		UNK_0C9D		= array(new Unsigned8[0x10]);
/*--0x0CAD--*/	public final Unsigned8[]		UNK_0CAD		= array(new Unsigned8[0x10]);
/*--0x0CBD--*/	public final Unsigned8[]		UNK_0CBD		= array(new Unsigned8[0x10]);
/*--0x0CCD--*/	public final Unsigned8[]		UNK_0CCD		= array(new Unsigned8[0x10]);
/*--0x0CDD--*/	public final Unsigned8[]		UNK_0CDD		= array(new Unsigned8[0x10]);
/*--0x0CED--*/	public final Unsigned8[]		UNK_0CED		= array(new Unsigned8[0x10]);
/*--0x0CFD--*/	public final Unsigned8[]		UNK_0CFD		= array(new Unsigned8[0x10]);

	public static final int STRUCT_SIZE = 32;



	public void print() {
		System.out.println("STR = "+stat_str + "/" + stat_str_max + " + " + bonus_str);
		System.out.println("INT = "+stat_int + "/" + stat_int_max + " + " + bonus_int);
		System.out.println("CON = "+stat_con + "/" + stat_con_max + " + " + bonus_con);
		System.out.println("DEX = "+stat_dex + "/" + stat_dex_max + " + " + bonus_dex);
		System.out.println("HP = "+hp + "/" + hp_max);
		System.out.println("Mana = "+mana + "/" + mana_max);
		System.out.println("Level = "+level);
		System.out.println("Exp = "+exp + "/" + exp_max);
		System.out.println("Armor = "+stat_armor);
		System.out.println("Hit bonus = "+stat_hitbonus);
		System.out.println("Damage bonus = "+stat_dmgbonus);
		System.out.println("Position (current) = X "+pos_x+", Y "+pos_y);
		System.out.println("Position (previous) = X "+pos_x_prev+", Y "+pos_y_prev);
		System.out.println("Name = "+name);
		System.out.println("Resistance (fire) = "+res_fire);
		System.out.println("Resistance (cold) = "+res_cold);
		System.out.println("Resistance (lightning) = "+res_lightning);
		System.out.println("Resistance (acid) = "+res_acid);
		System.out.println("Resistance (fear) = "+res_fear);
		System.out.println("Resistance (drainlife) = "+res_drainlife);
		System.out.println("Levitation = "+levitation);
		System.out.println("Spell # 1 = " +spell_1 + "\t  || " + hexdump(UNK_01B3, false));
		System.out.println("Spell # 2 = " +spell_2 + "\t  || " + hexdump(UNK_01BF, false));
		System.out.println("Spell # 3 = " +spell_3 + "\t  || " + hexdump(UNK_01CB, false));
		System.out.println("Spell # 4 = " +spell_4 + "\t  || " + hexdump(UNK_01D7, false));
		System.out.println("Spell # 5 = " +spell_5 + "\t  || " + hexdump(UNK_01E3, false));
		System.out.println("Spell # 6 = " +spell_6 + "\t  || " + hexdump(UNK_01EF, false));
		System.out.println("Spell # 7 = " +spell_7 + "\t  || " + hexdump(UNK_01FB, false));
		System.out.println("Spell # 8 = " +spell_8 + "\t  || " + hexdump(UNK_0207, false));
		System.out.println("Spell # 9 = " +spell_9 + "\t  || " + hexdump(UNK_0213, false));
		System.out.println("Spell #10 = " +spell_10 + "\t  || " + hexdump(UNK_021F, false));
		System.out.println("Spell #11 = " +spell_11 + "\t  || " + hexdump(UNK_022B, false));
		System.out.println("Spell #12 = " +spell_12 + "\t  || " + hexdump(UNK_0237, false));
		System.out.println("Spell #13 = " +spell_13 + "\t  || " + hexdump(UNK_0243, false));
		System.out.println("Spell #14 = " +spell_14 + "\t  || " + hexdump(UNK_024F, false));
		System.out.println("Spell #15 = " +spell_15 + "\t  || " + hexdump(UNK_025B, false));
		System.out.println("Spell #16 = " +spell_16 + "\t  || " + hexdump(UNK_0267, false));
		System.out.println("Spell #17 = " +spell_17 + "\t  || " + hexdump(UNK_0273, false));
		System.out.println("Spell #18 = " +spell_18 + "\t  || " + hexdump(UNK_027F, false));
		System.out.println("Spell #19 = " +spell_19 + "\t  || " + hexdump(UNK_028B, false));
		System.out.println("Spell #20 = " +spell_20 + "\t  || " + hexdump(UNK_0297, false));
		System.out.println("Spell #21 = " +spell_21 + "\t  || " + hexdump(UNK_02A3, false));
		System.out.println("Spell #22 = " +spell_22 + "\t  || " + hexdump(UNK_02AF, false));
		System.out.println("Spell #23 = " +spell_23 + "\t  || " + hexdump(UNK_02BB, false));
		System.out.println("Spell #24 = " +spell_24 + "\t  || " + hexdump(UNK_02C7, false));
		System.out.println("Spell #25 = " +spell_25 + "\t  || " + hexdump(UNK_02D3, false));
		System.out.println("Spell #26 = " +spell_26 + "\t  || " + hexdump(UNK_02DF, false));
		System.out.println("Spell #27 = " +spell_27 + "\t  || " + hexdump(UNK_02EB, false));
		System.out.println("Spell #28 = " +spell_28 + "\t  || " + hexdump(UNK_02F7, false));
		System.out.println("Spell #29 = " +spell_29 + "\t  || " + hexdump(UNK_0303, false));
		System.out.println("Spell #30 = " +spell_30 + "\t  || " + hexdump(UNK_030F, false));
		System.out.println("Spell #31 = " +spell_31 + "\t  || " + hexdump(UNK_031B, false));
		System.out.println("Spell #32 = " +spell_32 + "\t  || " + hexdump(UNK_0327, false));
		System.out.println("Spell #33 = " +spell_33 + "\t  || " + hexdump(UNK_0333, false));
		System.out.println("Spell #34 = " +spell_34 + "\t  || " + hexdump(UNK_033F, false));
		System.out.println("Spell #35 = " +spell_35 + "\t  || " + hexdump(UNK_034B, false));
		System.out.println("Spell #36 = " +spell_36 + "\t  || " + hexdump(UNK_0357, false));
		System.out.println("Icon = "+custicon_path);
		System.out.println("Copper = "+copper);
		System.out.println("Handicap = "+difficulty);


		System.out.println("");
		System.out.println("UNK_0000 = "+hexdump(UNK_0000, false));
		System.out.println("UNK_0010 = "+hexdump(UNK_0010, false));
		System.out.println("UNK_0020 = "+hexdump(UNK_0020, false));
		System.out.println("UNK_0030 = "+hexdump(UNK_0030, false));
		System.out.println("UNK_0040 = "+hexdump(UNK_0040, false));
		System.out.println("UNK_0050 = "+hexdump(UNK_0050, false));
		System.out.println("UNK_0060 = "+hexdump(UNK_0060, false));
		System.out.println("UNK_0070 = "+hexdump(UNK_0070, false));

		System.out.println("UNK_0088 = "+hexdump(UNK_0088, false));
		System.out.println("UNK_00AC = "+hexdump(UNK_00AC, false));

		System.out.println("UNK_00B8 = "+hexdump(UNK_00B8, false));
		System.out.println("UNK_00C8 = "+hexdump(UNK_00C8, false));
		System.out.println("UNK_00D8 = "+hexdump(UNK_00D8, false));
		System.out.println("UNK_00E8 = "+hexdump(UNK_00E8, false));
		System.out.println("UNK_00F8 = "+hexdump(UNK_00F8, false));

		System.out.println("UNK_0140 = "+hexdump(UNK_0140, false));

		System.out.println("UNK_015D = "+hexdump(UNK_015D, false));
		System.out.println("UNK_016D = "+hexdump(UNK_016D, false));
		System.out.println("UNK_017D = "+hexdump(UNK_017D, false));
		System.out.println("UNK_018D = "+hexdump(UNK_018D, false));
		System.out.println("UNK_019D = "+hexdump(UNK_019D, false));
		System.out.println("UNK_01AD = "+hexdump(UNK_01AD, false));

		System.out.println("UNK_0363 = "+hexdump(UNK_0363, false));
		System.out.println("UNK_0373 = "+hexdump(UNK_0373, false));
		System.out.println("UNK_0383 = "+hexdump(UNK_0383, false));
		System.out.println("UNK_0393 = "+hexdump(UNK_0393, false));
		System.out.println("UNK_03A3 = "+hexdump(UNK_03A3, false));
		System.out.println("UNK_03B3 = "+hexdump(UNK_03B3, false));
		System.out.println("UNK_03C3 = "+hexdump(UNK_03C3, false));

		System.out.println("UNK_03C7 = "+hexdump(UNK_03C7, false));
		System.out.println("UNK_03D7 = "+hexdump(UNK_03D7, false));
		System.out.println("UNK_03E7 = "+hexdump(UNK_03E7, false));
		System.out.println("UNK_03F7 = "+hexdump(UNK_03F7, false));
		System.out.println("UNK_0407 = "+hexdump(UNK_0407, false));
		System.out.println("UNK_0417 = "+hexdump(UNK_0417, false));
		System.out.println("UNK_0427 = "+hexdump(UNK_0427, false));
		System.out.println("UNK_0437 = "+hexdump(UNK_0437, false));
		System.out.println("UNK_0447 = "+hexdump(UNK_0447, false));
		System.out.println("UNK_0457 = "+hexdump(UNK_0457, false));
		System.out.println("UNK_0467 = "+hexdump(UNK_0467, false));
		System.out.println("UNK_0477 = "+hexdump(UNK_0477, false));
		System.out.println("UNK_0487 = "+hexdump(UNK_0487, false));
		System.out.println("UNK_0497 = "+hexdump(UNK_0497, false));
		System.out.println("UNK_04A7 = "+hexdump(UNK_04A7, false));
		System.out.println("UNK_04B7 = "+hexdump(UNK_04B7, false));
		System.out.println("UNK_04C7 = "+hexdump(UNK_04C7, false));
		System.out.println("UNK_04D7 = "+hexdump(UNK_04D7, false));

		System.out.println("UNK_04F8 = "+hexdump(UNK_04F8, false));
		System.out.println("UNK_0508 = "+hexdump(UNK_0508, false));
		System.out.println("UNK_0518 = "+hexdump(UNK_0518, false));
		System.out.println("UNK_0528 = "+hexdump(UNK_0528, false));
		System.out.println("UNK_0538 = "+hexdump(UNK_0538, false));
		System.out.println("UNK_0548 = "+hexdump(UNK_0548, false));
		System.out.println("UNK_0558 = "+hexdump(UNK_0558, false));
		System.out.println("UNK_0568 = "+hexdump(UNK_0568, false));

		System.out.println("UNK_056D = "+hexdump(UNK_056D, false));
		System.out.println("UNK_057D = "+hexdump(UNK_057D, false));
		System.out.println("UNK_058D = "+hexdump(UNK_058D, false));
		System.out.println("UNK_059D = "+hexdump(UNK_059D, false));
		System.out.println("UNK_05AD = "+hexdump(UNK_05AD, false));
		System.out.println("UNK_05BD = "+hexdump(UNK_05BD, false));
		System.out.println("UNK_05CD = "+hexdump(UNK_05CD, false));
		System.out.println("UNK_05DD = "+hexdump(UNK_05DD, false));
		System.out.println("UNK_05ED = "+hexdump(UNK_05ED, false));
		System.out.println("UNK_05FD = "+hexdump(UNK_05FD, false));
		System.out.println("UNK_060D = "+hexdump(UNK_060D, false));
		System.out.println("UNK_061D = "+hexdump(UNK_061D, false));
		System.out.println("UNK_062D = "+hexdump(UNK_062D, false));
		System.out.println("UNK_063D = "+hexdump(UNK_063D, false));
		System.out.println("UNK_064D = "+hexdump(UNK_064D, false));
		System.out.println("UNK_065D = "+hexdump(UNK_065D, false));
		System.out.println("UNK_066D = "+hexdump(UNK_066D, false));
		System.out.println("UNK_067D = "+hexdump(UNK_067D, false));
		System.out.println("UNK_068D = "+hexdump(UNK_068D, false));
		System.out.println("UNK_069D = "+hexdump(UNK_069D, false));
		System.out.println("UNK_06AD = "+hexdump(UNK_06AD, false));
		System.out.println("UNK_06BD = "+hexdump(UNK_06BD, false));
		System.out.println("UNK_06CD = "+hexdump(UNK_06CD, false));
		System.out.println("UNK_06DD = "+hexdump(UNK_06DD, false));
		System.out.println("UNK_06ED = "+hexdump(UNK_06ED, false));
		System.out.println("UNK_06FD = "+hexdump(UNK_06FD, false));
		System.out.println("UNK_070D = "+hexdump(UNK_070D, false));
		System.out.println("UNK_071D = "+hexdump(UNK_071D, false));
		System.out.println("UNK_072D = "+hexdump(UNK_072D, false));
		System.out.println("UNK_073D = "+hexdump(UNK_073D, false));
		System.out.println("UNK_074D = "+hexdump(UNK_074D, false));
		System.out.println("UNK_075D = "+hexdump(UNK_075D, false));
		System.out.println("UNK_076D = "+hexdump(UNK_076D, false));
		System.out.println("UNK_077D = "+hexdump(UNK_077D, false));
		System.out.println("UNK_078D = "+hexdump(UNK_078D, false));
		System.out.println("UNK_079D = "+hexdump(UNK_079D, false));
		System.out.println("UNK_07AD = "+hexdump(UNK_07AD, false));
		System.out.println("UNK_07BD = "+hexdump(UNK_07BD, false));
		System.out.println("UNK_07CD = "+hexdump(UNK_07CD, false));
		System.out.println("UNK_07DD = "+hexdump(UNK_07DD, false));
		System.out.println("UNK_07ED = "+hexdump(UNK_07ED, false));
		System.out.println("UNK_07FD = "+hexdump(UNK_07FD, false));
		System.out.println("UNK_080D = "+hexdump(UNK_080D, false));
		System.out.println("UNK_081D = "+hexdump(UNK_081D, false));
		System.out.println("UNK_082D = "+hexdump(UNK_082D, false));
		System.out.println("UNK_083D = "+hexdump(UNK_083D, false));
		System.out.println("UNK_084D = "+hexdump(UNK_084D, false));
		System.out.println("UNK_085D = "+hexdump(UNK_085D, false));
		System.out.println("UNK_086D = "+hexdump(UNK_086D, false));
		System.out.println("UNK_087D = "+hexdump(UNK_087D, false));
		System.out.println("UNK_088D = "+hexdump(UNK_088D, false));
		System.out.println("UNK_089D = "+hexdump(UNK_089D, false));
		System.out.println("UNK_08AD = "+hexdump(UNK_08AD, false));
		System.out.println("UNK_08BD = "+hexdump(UNK_08BD, false));
		System.out.println("UNK_08CD = "+hexdump(UNK_08CD, false));
		System.out.println("UNK_08DD = "+hexdump(UNK_08DD, false));
		System.out.println("UNK_08ED = "+hexdump(UNK_08ED, false));
		System.out.println("UNK_08FD = "+hexdump(UNK_08FD, false));
		System.out.println("UNK_090D = "+hexdump(UNK_090D, false));
		System.out.println("UNK_091D = "+hexdump(UNK_091D, false));
		System.out.println("UNK_092D = "+hexdump(UNK_092D, false));
		System.out.println("UNK_093D = "+hexdump(UNK_093D, false));
		System.out.println("UNK_094D = "+hexdump(UNK_094D, false));
		System.out.println("UNK_095D = "+hexdump(UNK_095D, false));
		System.out.println("UNK_096D = "+hexdump(UNK_096D, false));
		System.out.println("UNK_097D = "+hexdump(UNK_097D, false));
		System.out.println("UNK_098D = "+hexdump(UNK_098D, false));
		System.out.println("UNK_099D = "+hexdump(UNK_099D, false));
		System.out.println("UNK_09AD = "+hexdump(UNK_09AD, false));
		System.out.println("UNK_09BD = "+hexdump(UNK_09BD, false));
		System.out.println("UNK_09CD = "+hexdump(UNK_09CD, false));
		System.out.println("UNK_09DD = "+hexdump(UNK_09DD, false));
		System.out.println("UNK_09ED = "+hexdump(UNK_09ED, false));
		System.out.println("UNK_09FD = "+hexdump(UNK_09FD, false));
		System.out.println("UNK_0A0D = "+hexdump(UNK_0A0D, false));
		System.out.println("UNK_0A1D = "+hexdump(UNK_0A1D, false));
		System.out.println("UNK_0A2D = "+hexdump(UNK_0A2D, false));
		System.out.println("UNK_0A3D = "+hexdump(UNK_0A3D, false));
		System.out.println("UNK_0A4D = "+hexdump(UNK_0A4D, false));
		System.out.println("UNK_0A5D = "+hexdump(UNK_0A5D, false));
		System.out.println("UNK_0A6D = "+hexdump(UNK_0A6D, false));
		System.out.println("UNK_0A7D = "+hexdump(UNK_0A7D, false));
		System.out.println("UNK_0A8D = "+hexdump(UNK_0A8D, false));
		System.out.println("UNK_0A9D = "+hexdump(UNK_0A9D, false));
		System.out.println("UNK_0AAD = "+hexdump(UNK_0AAD, false));
		System.out.println("UNK_0ABD = "+hexdump(UNK_0ABD, false));
		System.out.println("UNK_0ACD = "+hexdump(UNK_0ACD, false));
		System.out.println("UNK_0ADD = "+hexdump(UNK_0ADD, false));
		System.out.println("UNK_0AED = "+hexdump(UNK_0AED, false));
		System.out.println("UNK_0AFD = "+hexdump(UNK_0AFD, false));
		System.out.println("UNK_0B0D = "+hexdump(UNK_0B0D, false));
		System.out.println("UNK_0B1D = "+hexdump(UNK_0B1D, false));
		System.out.println("UNK_0B2D = "+hexdump(UNK_0B2D, false));
		System.out.println("UNK_0B3D = "+hexdump(UNK_0B3D, false));
		System.out.println("UNK_0B4D = "+hexdump(UNK_0B4D, false));
		System.out.println("UNK_0B5D = "+hexdump(UNK_0B5D, false));
		System.out.println("UNK_0B6D = "+hexdump(UNK_0B6D, false));
		System.out.println("UNK_0B7D = "+hexdump(UNK_0B7D, false));
		System.out.println("UNK_0B8D = "+hexdump(UNK_0B8D, false));
		System.out.println("UNK_0B9D = "+hexdump(UNK_0B9D, false));
		System.out.println("UNK_0BAD = "+hexdump(UNK_0BAD, false));
		System.out.println("UNK_0BBD = "+hexdump(UNK_0BBD, false));
		System.out.println("UNK_0BCD = "+hexdump(UNK_0BCD, false));
		System.out.println("UNK_0BDD = "+hexdump(UNK_0BDD, false));
		System.out.println("UNK_0BED = "+hexdump(UNK_0BED, false));
		System.out.println("UNK_0BFD = "+hexdump(UNK_0BFD, false));
		System.out.println("UNK_0C0D = "+hexdump(UNK_0C0D, false));
		System.out.println("UNK_0C1D = "+hexdump(UNK_0C1D, false));
		System.out.println("UNK_0C2D = "+hexdump(UNK_0C2D, false));
		System.out.println("UNK_0C3D = "+hexdump(UNK_0C3D, false));
		System.out.println("UNK_0C4D = "+hexdump(UNK_0C4D, false));
		System.out.println("UNK_0C5D = "+hexdump(UNK_0C5D, false));
		System.out.println("UNK_0C6D = "+hexdump(UNK_0C6D, false));
		System.out.println("UNK_0C7D = "+hexdump(UNK_0C7D, false));
		System.out.println("UNK_0C8D = "+hexdump(UNK_0C8D, false));
		System.out.println("UNK_0C9D = "+hexdump(UNK_0C9D, false));
		System.out.println("UNK_0CAD = "+hexdump(UNK_0CAD, false));
		System.out.println("UNK_0CBD = "+hexdump(UNK_0CBD, false));
		System.out.println("UNK_0CCD = "+hexdump(UNK_0CCD, false));
		System.out.println("UNK_0CDD = "+hexdump(UNK_0CDD, false));
		System.out.println("UNK_0CED = "+hexdump(UNK_0CED, false));
		System.out.println("UNK_0CFD = "+hexdump(UNK_0CFD, false));
	}
}

public class Main {
	// test main
	public static void main(String[] args) throws Exception {
		String FILENAME="testsave1.cwg";
		byte[] data = Files.readAllBytes(Paths.get(FILENAME));
		ByteBuffer buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.LITTLE_ENDIAN);
		Savefile s = new Savefile();
		s.setByteBuffer(buffer, 0);
		s.print();
	}
}

