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


package javolution.io;

import javolution.io.Struct;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class PackedStruct extends Struct {

	// Colors nonzero bytes in hexdump through ANSI escape sequencies. Requires a color terminal
	private static final boolean ANSI_COLOR_NONZERO = true;

	private int bb_offset;

	public PackedStruct() {}

	public PackedStruct(byte[] data, int offs) {
		this(ByteBuffer.wrap(data), offs);
	}

	public PackedStruct(ByteBuffer buf, int offs) {
		bb_offset = offs;
		buf.order(ByteOrder.LITTLE_ENDIAN);
		setByteBuffer(buf, offs);
	}

	public boolean isPacked() {
		return true;
	}
	public ByteOrder byteOrder() {
		return ByteOrder.LITTLE_ENDIAN;
	}

	public byte[] getBytes() {
		byte[] ret = new byte[size()];
		System.arraycopy(getByteBuffer().array(), bb_offset, ret, 0, size());
		return ret;
	}




	public static String hexdump(final Unsigned8[] a, final int start, int end, final boolean header) {
		byte[] b = new byte[a.length];
		for (int i=0; i<a.length; i++) {
			b[i] = (byte)(a[i].get() & 0xFF);
		}

		if (end > b.length)
			end = b.length;

		int len = end-start;
		String str = "";
		if (header)
			str = "array["+start+", "+end+"]:"+len+"\n";
		if (len<0)
			return str+"?? length = "+len;
		if (b.length != 0) {
			for (int i=start; i<end; i++) {
				String digit = String.format("%02x ", b[i]);
				if (b[i] == 0 || !ANSI_COLOR_NONZERO)
					str += digit;
				else
					str += "\033[33;1m"+digit+"\033[0m";

				if ((i-start) % 16 == 15 && i!=end-1)
					str += "\n";
			}
		}
		return str;
	}

	public static String hexdump(final Unsigned8[] a, final int start, final int end) {
		return hexdump(a, start, end, true);
	}

	public static String hexdump(final Unsigned8[] a, final boolean header) {
		return hexdump(a, 0, a.length, header);
	}

	public static String hexdump(final Unsigned8[] a) {
		return hexdump(a, 0, a.length);
	}


}
